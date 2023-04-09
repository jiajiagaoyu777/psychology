package com.whlg.psychology.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)//继承基类方法
public class Admin extends BaseEntity{
    @ApiModelProperty("管理员id")
    private Integer admin_id;
    @ApiModelProperty("管理员用户名")
    private String admin_name;
    @ApiModelProperty("密码")
    private String admin_pwd;
    @ApiModelProperty("盐值")
    private String salt;
    @ApiModelProperty("头像")
    private String admin_avatar;
}
