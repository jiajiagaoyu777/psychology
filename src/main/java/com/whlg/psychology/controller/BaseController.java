package com.whlg.psychology.controller;

import com.whlg.psychology.service.ex.*;
import com.whlg.psychology.utils.JsonResult;
import org.omg.CORBA.UserException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制类的基类
 */
public class BaseController {
    //定义一个成功的状态码的常量
    public static final int OK=200;

    //自定义异常的拦截
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handlerException(Throwable e){
        //创建结果集对象，做异常返回处理
        JsonResult<Void> result= new JsonResult<Void>(e);

        if (e instanceof UserException){
            result.setCode(201);
//            result.setMessage("用户名重复，请换个名称");//这里不用再setMessage了，因为UserServiceImpl里面throw异常的时候已经附上message了，然后就会被各种exception的构造函数读取到
        }else if (e instanceof InsertException){
            result.setCode(202);
//            result.setMessage("添加失败，请联系管理员(持久层插入失败导致业务层插入失败而抛出的异常)");
        }else if (e instanceof PasswordNotMatchException){
            result.setCode(203);
        }
        else if (e instanceof UpdateException){
            result.setCode(204);
        }else if (e instanceof SelectException){
            result.setCode(205);
        }else if (e instanceof FileException){
            result.setCode(206);
        }//把207空出来，207赋给了尚未通过审核的医生
        return result;
    }
}
