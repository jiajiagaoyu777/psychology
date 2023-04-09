package com.whlg.psychology.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)//继承基类方法
public class Factor {
    @ApiModelProperty("因子id")
    private Integer factor_id;
    @ApiModelProperty("因子名")
    private String factor_name;
}
