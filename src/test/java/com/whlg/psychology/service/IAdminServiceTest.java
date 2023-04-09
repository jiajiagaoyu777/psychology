package com.whlg.psychology.service;

import com.whlg.psychology.entity.Admin;
import com.whlg.psychology.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class IAdminServiceTest {

    //注入业务层对象
    @Autowired
    private IAdminService iAdminService;

    @Test
    void addAdmin() {
        Admin admin = new Admin();
        admin.setAdmin_name("aaa001");
        admin.setAdmin_pwd("123456");//由于要模拟前端的功能，前端注册的时候页面只有输入用户名和密码，别的信息用户都没有输入所以得由UserServiceImpl去做日志的补全（即生成“创建时间”“修改时间”之类的）

        try{
            iAdminService.addAdmin(admin);
            System.out.println("注册成功");
        }catch (ServiceException e){
            System.out.println("注册失败,"+e.getMessage());
        }
    }

    @Test
    void login(){
        Admin admin=iAdminService.login("jjj003","123456");
        System.out.println(admin);//为什么父类里的日志信息读不出来？
    }

    @Test
    void editAdminPwd(){
        Integer admin_id = 4;
        String oldPwd = "123456";
        String newPwd = "777777";
        String admin_name = "闸浩宇";
        try {
            iAdminService.editAdminPwd(admin_id,oldPwd,newPwd,admin_name);
            System.out.println("更新密码成功！");
        } catch (ServiceException e) {
            System.out.println("更新密码失败：" + e.getMessage());
        }
    }

//    @Test
//    void editInfo(){
//        Admin admin=new Admin();
//        admin.setUid(10);
//        admin.setAdmin_name("ceshi005");
//        admin.setPhone("666666666");
//        admin.setEmail("alialialiali@aliyun.com");
//        admin.setSex(1);
//        try {
//            iAdminService.editInfo(admin);
//            System.out.println("更新成功");
//        } catch (Exception e) {
//            System.out.println("更新失败"+e.getMessage());
//        }
//    }
}