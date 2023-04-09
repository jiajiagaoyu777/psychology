package com.whlg.psychology.mapper;

import com.whlg.psychology.entity.Patient;

import java.util.Date;

public interface PatientMapper {

    int insertPatient(Patient patient);

    public Patient findByPatientname(String patient_name);

    public int updatePatientPwd(Integer patient_id, String patient_pwd, String changeUser, Date changeTime);

    Patient findByPatientId(Integer patient_id);

//    int updateInfo(Patient patient);

    int updatePatientAvatar(int patient_id,String avatar,String changeUser,Date changeTime);

}
