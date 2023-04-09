package com.whlg.psychology.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)//继承基类方法
public class Scale {
    @ApiModelProperty("量表id")
    private Integer scale_id;
    @ApiModelProperty("量表标题")
    private String scale_name;
    @ApiModelProperty("量表简介")
    private String brief;
    @ApiModelProperty("量表类型")
    private Integer type;
    @ApiModelProperty("量表设置")
    private String scale_settings;
    @ApiModelProperty("量表权限")
    private Integer scale_authority;
}
