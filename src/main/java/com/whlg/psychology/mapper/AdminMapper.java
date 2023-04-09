package com.whlg.psychology.mapper;

import com.whlg.psychology.entity.Admin;

import java.util.Date;

public interface AdminMapper {
    int insertAdmin(Admin admin);

    public Admin findByAdminName(String admin_name);

    public int updateAdminPwd(Integer admin_id, String admin_pwd, String changeUser, Date changeTime);

    Admin findByAdminId(Integer admin_id);

//    int updateInfo(Admin admin);

    int updateAdminAvatar(int admin_id,String avatar,String changeUser,Date changeTime);

}
