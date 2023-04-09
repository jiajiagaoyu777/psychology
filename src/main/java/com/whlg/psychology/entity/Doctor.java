package com.whlg.psychology.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)//继承基类方法
public class Doctor extends BaseEntity{
    @ApiModelProperty("医生id")
    private Integer doctor_id;
    @ApiModelProperty("医生用户名")
    private String doctor_name;
    @ApiModelProperty("医生密码")
    private String doctor_pwd;
    @ApiModelProperty("盐值")
    private String salt;
    @ApiModelProperty("医生头像")
    private String doctor_avatar;
    @ApiModelProperty("医生六位资格证编号")
    private Integer certificate;
    @ApiModelProperty("医生身份认证")
    private Integer is_doctor;
}
