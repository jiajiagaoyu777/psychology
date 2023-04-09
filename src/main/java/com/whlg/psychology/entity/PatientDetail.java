package com.whlg.psychology.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)//继承基类方法
public class PatientDetail {
    @ApiModelProperty("详情id")
    private Integer detail_id;
    @ApiModelProperty("患者用户名")
    private String patient_name;
    @ApiModelProperty("患者电话")
    private String phone;
    @ApiModelProperty("生日")
    private String birthday;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("教育经历")
    private Integer education;
    @ApiModelProperty("职业")
    private String job;
    @ApiModelProperty("心理病史")
    private String history;
}
