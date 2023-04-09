package com.whlg.psychology.controller;

import com.whlg.psychology.entity.Doctor;
import com.whlg.psychology.entity.Patient;
import com.whlg.psychology.service.IDoctorService;
import com.whlg.psychology.service.IPatientService;
import com.whlg.psychology.service.ex.FileException;
import com.whlg.psychology.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
@Api(tags = "患者模块")
public class PatientController extends BaseController{
    //允许的文件类型管理
    public static final List<String> AVATAR_TYPES=new ArrayList<String>();
    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/gif");
    }

    //允许文件上传的大小上限
    public static final int AVATAR_MAX_SIZE=10*1024*1024;

    //控制器需要注入业务层对象
    @Autowired
    private IPatientService iPatientService;

    @PostMapping("/reg")
    @ApiOperation("注册接口")
    public JsonResult<Void> reg(@RequestBody Patient patient){

        //创建结果集对象，返回数据给客户端
        JsonResult<Void> result=new JsonResult<>();

        //调用业务层的添加用户方法
        iPatientService.addPatient(patient);
        return new JsonResult<Void>(OK);
    }

    @PostMapping("/login")
    @ApiOperation("登录接口")
    public JsonResult<Patient> login(@RequestParam("patient_name") String username, @RequestParam("patient_pwd") String password){
        Patient data= iPatientService.login(username,password);
        return new JsonResult<Patient>(OK,data);
    }

    @PutMapping("/changePwd")
    @ApiOperation("更新密码接口")
    public JsonResult<Void> changePatientPwd(Integer patient_id,String oldPwd,String newPwd,String patient_name){
        iPatientService.editPatientPwd(patient_id,oldPwd,newPwd,patient_name);
        return new JsonResult<Void>(OK);
    }

//    @GetMapping("/get_by_uid")
//    @ApiOperation("获取用户信息")
//    public JsonResult<Patient> getByUid(int id){
//        Patient data= iUserService.getByUid(id);
//        return new  JsonResult<Patient>(OK,data);
//    }
//
//    @PutMapping("/change_info")
//    @ApiOperation("用户信息修改接口")
//    public JsonResult<Void> changeInfo(Patient patient){
//        iUserService.editInfo(patient);
//        return new  JsonResult<Void>(OK);
//    }

    @PostMapping("/changeAvatar")
    @ApiOperation("用户头像上传修改")
    /**
     * avatar是一个图片文件，上传图片文件会用到spring MVC的上传图片插件MultipartFile
     */
    public JsonResult<String> changeAvatar(int patient_id, MultipartFile file, String patient_name, HttpSession session){

        if(file.isEmpty()){
            throw new FileException("上传头像文件不能为空");
        }
        //1.文件上传大小的约束
        if (file.getSize()>AVATAR_MAX_SIZE){
            throw new FileException("上传的头像过大,不允许超过"+(AVATAR_MAX_SIZE/1024/1024) +"MB");
        }

        //2.文件上传类型的约束
        String contentType= file.getContentType();
        if (!AVATAR_TYPES.contains(contentType)){
            throw new FileException("文件上传类型错误");
        }

        //3.上传的文件保存在本地服务器，图片地址保存在数据库
        //3.1获取当前项目在磁盘的绝对路径，创建上传文件的目录
        //D:/graduation_project/psychology+/upload
        String parent=session.getServletContext().getRealPath("upload");
        File dir= new File(parent);
        if (!dir.exists()){//检测获取的文件目录是否存在
            dir.mkdirs();//如果不存在就创建当前目录“D:/project/shop+/upload”
        }
        //保存图片文件，获取图片地址的文件名及后缀（随机生成文件名，比如ava.png=>23423234jjasdad.png,因为用户上传的文件可能是重名的所以我们得自己生成文件名）
        //获取出整个文件名称
        String fileName=file.getOriginalFilename();
        //取出文件名中“.”（比如ava.png中的这个连接点）的下标
        int index=fileName.lastIndexOf(".");
        String suffix="";//suffix代表后缀的意思
        //取出文件后缀
        if (index>0){
            suffix=fileName.substring(index);
        }
        //生成随机的图片名+文件类型后缀
        String newFileName= UUID.randomUUID().toString()+suffix;
        //保存图片在本地磁盘
        File dest= new File(dir,newFileName);
        try {
            file.transferTo(dest);//这一步如果不加try-catch的话会飘红报错的而且报的不是直观的错
        } catch (IOException e) {
            throw new FileException("上传文件失败，请联系管理员");
        }

        //3.2图片地址保存至数据库中 http://8080+/upload/dgfsdasdf.jpg
        String patient_avatar="/upload/"+newFileName;
        //调用业务层的更新头像的方法
        iPatientService.editPatientAvatar(patient_id,patient_avatar,patient_name);
        //返回结果集=>图片地址
        return new JsonResult<String>(OK,patient_avatar);

    }
}
