package com.whlg.psychology.mapper;

import com.whlg.psychology.entity.Doctor;
import com.whlg.psychology.entity.PatientDetail;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class PatientDetailMapperTest {

    //注入mapper层对象
    @Autowired(required=false)//表示忽略当前要注入的bean，如果有直接注入，没有跳过，不会报错。
    private PatientDetailMapper patientDetailMapper;//这里报错不用管，老师说是IDEA的问题，实际上已经注入进来

    @Test
    void insertPatientDetail() {
        PatientDetail pd=new PatientDetail();
        pd.setPatient_name("pd1");

        int count = patientDetailMapper.insertPatientDetail(pd);
        System.out.println("新增"+count+"行数据成功");
    }
}