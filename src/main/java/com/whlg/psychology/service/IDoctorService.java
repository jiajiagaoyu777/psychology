package com.whlg.psychology.service;

import com.whlg.psychology.entity.Admin;
import com.whlg.psychology.entity.Doctor;

public interface IDoctorService {
    /**
     * 添加用户
     * @param doctor
     */
    void addDoctor(Doctor doctor);

    /**
     * 登录的验证
     * @param doctor_name
     * @param doctor_pwd
     * @return 用户对象Doctor
     */
    Doctor login(String doctor_name, String doctor_pwd);

    /**
     * 根据用户doctor_id修改密码
     * @param doctor_id
     * @param oldPwd
     * @param newPwd
     * @param doctor_name
     */
    void editDoctorPwd(Integer doctor_id,String oldPwd,String newPwd,String doctor_name);

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
     * @param doctor_id
     * @param doctor_avatar
     * @param doctor_name
     */
    void editDoctorAvatar(int doctor_id,String doctor_avatar,String doctor_name);
}
