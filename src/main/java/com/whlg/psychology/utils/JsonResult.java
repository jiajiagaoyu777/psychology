package com.whlg.psychology.utils;

import lombok.Data;

@Data
public class JsonResult<E> {
    //状态码
    private Integer code;
    //提示信息
    private String message;
    //数据
    private E data;//E代表泛型：可代表各种数据类型

    public JsonResult() {

    }

    public JsonResult(Integer code) {
        this.code = code;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer code, E data) {
        this.code = code;
        this.data = data;
    }
}
