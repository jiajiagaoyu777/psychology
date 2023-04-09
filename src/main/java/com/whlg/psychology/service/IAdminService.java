package com.whlg.psychology.service;

import com.whlg.psychology.entity.Admin;

public interface IAdminService {
    /**
     * 添加用户
     * @param admin
     */
    void addAdmin(Admin admin);

    /**
     * 登录的验证
     * @param admin_name
     * @param admin_pwd
     * @return 用户对象Admin
     */
    Admin login(String admin_name,String admin_pwd);

    /**
     * 根据用户admin_id修改密码
     * @param admin_id
     * @param oldPwd
     * @param newPwd
     * @param admin_name
     */
    void editAdminPwd(Integer admin_id,String oldPwd,String newPwd,String admin_name);

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
     * @param admin_id
     * @param admin_avatar
     * @param admin_name
     */
    void editAdminAvatar(int admin_id,String admin_avatar,String admin_name);
}
