package com.whlg.psychology.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@ToString(callSuper = true)//继承基类方法
public class Patient extends BaseEntity{
    @ApiModelProperty("患者id")
    private Integer patient_id;
    @ApiModelProperty("患者用户名")
    private String patient_name;
    @ApiModelProperty("患者密码")
    private String patient_pwd;
    @ApiModelProperty("盐值")
    private String salt;
    @ApiModelProperty("患者头像")
    private String patient_avatar;
    @ApiModelProperty("主治医师id")
    private Integer doctor_id;
    @ApiModelProperty("主治医师用户名")
    private String doctor_name;
}
