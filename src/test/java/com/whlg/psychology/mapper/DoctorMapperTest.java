package com.whlg.psychology.mapper;

import com.whlg.psychology.entity.Admin;
import com.whlg.psychology.entity.Doctor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class DoctorMapperTest {

    //注入mapper层对象
    @Autowired(required=false)//表示忽略当前要注入的bean，如果有直接注入，没有跳过，不会报错。
    private DoctorMapper doctorMapper;//这里报错不用管，老师说是IDEA的问题，实际上已经注入进来

    @Test
    void insertDoctor() {
        Doctor doctor=new Doctor();
        doctor.setDoctor_name("ddd001");
        doctor.setDoctor_pwd("123456");
        doctor.setCertificate(111111);
        doctor.setCreatedUser("zhahaoyu");
        doctor.setCreatedTime(new Date());
        doctor.setChangeUser("zhahaoyu");
        doctor.setChangeTime(new Date());

        int count = doctorMapper.insertDoctor(doctor);
        System.out.println("新增"+count+"行数据成功");
    }

    @Test
    void findByDoctorname() {
        Doctor result=doctorMapper.findByDoctorname("ddd001");
        System.out.println(result);
    }
}