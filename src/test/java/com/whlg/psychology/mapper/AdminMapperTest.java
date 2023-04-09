package com.whlg.psychology.mapper;

import com.whlg.psychology.entity.Admin;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class AdminMapperTest {
    //注入mapper层对象
    @Autowired(required=false)//表示忽略当前要注入的bean，如果有直接注入，没有跳过，不会报错。
    private AdminMapper adminMapper;//这里报错不用管，老师说是IDEA的问题，实际上已经注入进来了

    @Test
    void insertAdmin() {
        Admin admin=new Admin();
        admin.setAdmin_name("jjj001");
        admin.setAdmin_pwd("123456");
        admin.setCreatedUser("闸浩宇");
        admin.setCreatedTime(new Date());
        admin.setChangeUser("闸浩宇");
        admin.setChangeTime(new Date());

        int count = adminMapper.insertAdmin(admin);
        System.out.println("新增"+count+"行数据成功");
    }

    @Test
    void findByAdminName() {
        Admin result=adminMapper.findByAdminName("jjj001");
        System.out.println(result);
    }

    @Test
    public void updateAdminPwd(){
        Integer admin_id=1;
        String admin_pwd="777777";
        String changeUser="甲甲";
        Date changeTime=new Date();
        Integer rows= adminMapper.updateAdminPwd(admin_id,admin_pwd,changeUser,changeTime);
        if(rows>0){
            System.out.println("更新"+rows+"行数据（密码）成功");
        }else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void findByAdminId(){
        Admin admin= adminMapper.findByAdminId(1);
        System.out.println(admin);
    }

//    @Test
//    public void updateInfo(){
//        User user=new User();
//        user.setPhone("12345");
//        user.setEmail("abaaba@163.com");
//        user.setSex(1);
//        user.setUid(10);
//        user.setChangeUser("系统管理员");
//        user.setChangeTime(new Date());
//        int count=userMapper.updateInfo(user);
//        if (count>0){
//            System.out.println("更新成功");
//        }else {
//            System.out.println("更新失败");
//        }
//    }

    @Test
    public void updateAvatar(){
        int admin_id=3;
        String admin_avatar="img/2.png";
        String admin_name="闸浩宇";
        Date changeTime=new Date();
        int rows= adminMapper.updateAdminAvatar(admin_id,admin_avatar,admin_name,changeTime);
        if (rows>0){
            System.out.println("更新管理员头像成功");
        }else {
            System.out.println("更新管理员头像失败");
        }
    }
}