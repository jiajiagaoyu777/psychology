package com.whlg.psychology.service;

import com.whlg.psychology.entity.Patient;

public interface IPatientService {
    /**
     * 添加用户
     * @param patient
     */
    void addPatient(Patient patient);

    /**
     * 登录的验证
     * @param patient_name
     * @param patient_pwd
     * @return 用户对象Patient
     */
    Patient login(String patient_name, String patient_pwd);

    /**
     * 根据用户patient_id修改密码
     * @param patient_id
     * @param oldPwd
     * @param newPwd
     * @param patient_name
     */
    void editPatientPwd(Integer patient_id,String oldPwd,String newPwd,String patient_name);

//    /**
//     * 根据用户uid查询当前用户对象
//     * @param uid
//     * @return 用户对象
//     */
//    Admin getByUid(int uid);
//
//    /**
//     * 根据uid修改用户信息
//     * @param admin
//     */
//    void editInfo(Admin admin);

    /**
     * 根据uid修改用户头像
     * @param patient_id
     * @param patient_avatar
     * @param patient_name
     */
    void editPatientAvatar(int patient_id,String patient_avatar,String patient_name);
}
