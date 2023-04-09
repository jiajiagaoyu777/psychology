package com.whlg.psychology.service.impl;

import com.whlg.psychology.entity.Admin;
import com.whlg.psychology.mapper.AdminMapper;
import com.whlg.psychology.service.IAdminService;
import com.whlg.psychology.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired(required = false)
    private AdminMapper adminMapper;

    /**
     *调用持久层方法判断是否存在该管理员用户名，存在抛出异常
     * 没被占用
     */
    @Override
    public void addAdmin(Admin admin) {
        String admin_name = admin.getAdmin_name();
        Admin result = adminMapper.findByAdminName(admin_name);
        if(result!=null){
            throw new AdminException("管理员用户名"+admin_name+"重复,请换个用户名注册");
        }
        //补全日志信息
        Date now = new Date();
        admin.setChangeUser(admin.getAdmin_name());
        admin.setCreatedUser(admin.getAdmin_name());
        admin.setChangeTime(now);
        admin.setCreatedTime(now);


        /**
         * 密码加密，使用MD5加密
         * MD5是一个算法，类似于字符替换，但这个算法容易被反编译，所以前后要拼接一点东西
         * 盐值+password+盐值
         * 随机串+password+随机串
         * 随机串是使用UUID工具生成的，再将生成的字符转写成大写字符
         */
        String salt= UUID.randomUUID().toString().toUpperCase();
        String md5Password=getMd5Password(admin.getAdmin_pwd(),salt);
        //保存密码和盐值到数据库（盐值用于解密）
        admin.setAdmin_pwd(md5Password);
        admin.setSalt(salt);

        int rows = adminMapper.insertAdmin(admin);
        if(rows!=1){
            throw new InsertException("注册失败");
        }
    }

    @Override
    public Admin login(String admin_name, String admin_pwd) {
        //1.登录时根据用户名查询是否存在该用户,若不存在则抛出异常
        Admin result=adminMapper.findByAdminName(admin_name);
        if (result==null){
            throw new AdminException("用户数据不存在，请换个账号登录试试");
        }
        //2.若存在则进行密码校验
        //2.1.取出查询出来的用户对象的盐值，进行MD5加密对比
        String salt=result.getSalt();
        //2.2.结合登陆输入的密码进行再次MD5加密，加密之后的密码和数据库内的密码对比
        String md5password= getMd5Password(admin_pwd,salt);
        if(!result.getAdmin_pwd().equals(md5password)){
            throw new PasswordNotMatchException("数据库保存到密码和当前输入的密码加密后的结果不相等，故密码错误登录失败");
        }

        //3.返回结果集登录的用户信息,只返回有用的信息
        Admin admin=new Admin();
        admin.setAdmin_id(result.getAdmin_id());
        admin.setAdmin_name(result.getAdmin_name());
//        admin.setAvatar(result.getAvatar());

        return admin;
    }

    @Override
    public void editAdminPwd(Integer admin_id, String oldPwd, String newPwd, String admin_name) {
        //1.查询用户的信息是否存在，不存在则输出异常
        Admin result=adminMapper.findByAdminId(admin_id);
        if (result==null){
            throw new AdminException("该管理员用户数据不存在");
        }
        //2.若存在则进行输入的密码和数据库密码对比
        String salt=result.getSalt();
        String oldMd5password=getMd5Password(oldPwd, salt);
        if (!result.getAdmin_pwd().equals(oldMd5password)){
            throw new PasswordNotMatchException("旧密码出错");
        }
        //3.若相同则对新密码加密并保存
        String newMd5Password=getMd5Password(newPwd,salt);
        Date now=new Date();
        Integer rows= adminMapper.updateAdminPwd(admin_id,newMd5Password,admin_name,now);
        if(rows!=1){
            throw new UpdateException("更新用户数据失败");
        }
    }

//    @Override
//    public Admin getByUid(int uid) {
//        Admin result= adminMapper.findByUid(uid);
//        if (result==null){
//            throw new SelectException("（根据uid查询）获取用户数据失败");
//        }
//        return result;
//    }
//
//    @Override
//    public void editInfo(Admin admin) {
//        //1.调用查询方法，判断当前数据是否存在，不存在抛出异常
//        Admin result= adminMapper.findByUid(admin.getUid());
//        if (result==null){
//            throw new AdminException("用户数据不存在");
//        }
//        //完善用户信息
//        admin.setChangeAdmin(admin.getAdminname());//因为这是用户登陆之后自己改的所以更改人是他自己
//        admin.setChangeTime(new Date());
//        //2.若数据存在，则调用更新用户信息方法
//        int rows= adminMapper.updateInfo(admin);
//        if (rows!=1){
//            throw new AdminException("更新用户数据失败，请联系管理员");
//        }
//    }

    @Override
    public void editAdminAvatar(int admin_id, String admin_avatar, String admin_name) {
        //1.查询是否存在这条修改的用户数据
        Admin result= adminMapper.findByAdminId(admin_id);
        if (result==null){
            throw new SelectException("用户数据不存在");
        }
        //2.若存在则调用持久层修改头像的方法
        Date now=new Date();
        int rows= adminMapper.updateAdminAvatar(admin_id,admin_avatar,admin_name,now);
        if (rows!=1){
            throw new UpdateException("修改头像失败");
        }
    }

    /**
     * 将MD5加密算法进一步加工
     * 循环加密三次，提升加密强度
     * @param password
     * @param salt
     * @return
     */
    private String getMd5Password(String password,String salt){
        for (int i=0;i<3;i++){
            password=  DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }
}