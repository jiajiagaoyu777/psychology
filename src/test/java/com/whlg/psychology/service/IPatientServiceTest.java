package com.whlg.psychology.service;

import com.whlg.psychology.entity.Doctor;
import com.whlg.psychology.entity.Patient;
import com.whlg.psychology.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class IPatientServiceTest {

    //注入业务层对象
    @Autowired
    private IPatientService iPatientService;

    @Test
    void addPatient() {
        Patient patient = new Patient();
        patient.setPatient_name("ppp005");
        patient.setPatient_pwd("123456");//由于要模拟前端的功能，前端注册的时候页面只有输入用户名和密码，别的信息用户都没有输入所以得由UserServiceImpl去做日志的补全（即生成“创建时间”“修改时间”之类的）
        try{
            iPatientService.addPatient(patient);
            System.out.println("注册成功");
        }catch (ServiceException e){
            System.out.println("注册失败,"+e.getMessage());
        }
    }

    @Test
    void login() {
    }

    @Test
    void editPatientPwd() {
    }

    @Test
    void editPatientAvatar() {
    }
}