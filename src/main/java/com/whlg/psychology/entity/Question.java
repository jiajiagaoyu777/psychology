package com.whlg.psychology.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)//继承基类方法
public class Question {
    @ApiModelProperty("题目id")
    private Integer question_id;
    @ApiModelProperty("题目内容")
    private String question_content;
    @ApiModelProperty("选项及对应设置的JSON")
    private String options;
}
