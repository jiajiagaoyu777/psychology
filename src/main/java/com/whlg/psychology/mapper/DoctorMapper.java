package com.whlg.psychology.mapper;

import com.whlg.psychology.entity.Admin;
import com.whlg.psychology.entity.Doctor;

import java.util.Date;

public interface DoctorMapper {

    int insertDoctor(Doctor doctor);

    public Doctor findByDoctorname(String doctor_name);

    public int updateDoctorPwd(Integer doctor_id, String doctor_pwd, String changeUser, Date changeTime);

    Doctor findByDoctorId(Integer doctor_id);

//    int updateInfo(Doctor doctor);

    int updateDoctorAvatar(int doctor_id,String avatar,String changeUser,Date changeTime);

}
