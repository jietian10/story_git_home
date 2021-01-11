package com.hfxt.controller;

import com.hfxt.model.Account;
import com.hfxt.tools.CustomToken;
import com.hfxt.tools.Result;
import com.hfxt.tools.StatusCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class AccountController extends BaseController{
    /**
     * 登录
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value = "checkLogin",produces = "application/json;charset=UTF-8")
    public Result checkLogin(Account user, HttpSession session){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag=true;
        Integer code=0;
        String msg="";

        try {
            //认证对象
            Subject subject= SecurityUtils.getSubject();
            //封装用户信息
            UsernamePasswordToken token=new CustomToken(user.getUsername(),user.getPassword());
            //提交认证
            subject.login(token);
            //查询user信息
            user = accountService.selectByCon(user);
            //session存此用户信息
            session.setAttribute("user",accountService.selectByCon(user));
            //传递数据
            map.put("randCode", session.getAttribute("randCode"));
            map.put("user",user);
            flag=true;
            code=StatusCode.OK;
            msg="";
        } catch (UnknownAccountException e) {
            map.clear();
            flag=false;
            code = StatusCode.LOGINERROR;
            msg="账号或密码错误！";
        } catch (IncorrectCredentialsException e) {
            map.clear();
            flag=false;
            msg="账号或密码错误！";
            code = StatusCode.LOGINERROR;
        } catch (AuthenticationException e) {
            map.clear();
            flag=false;
            code = StatusCode.ERROR;
            msg="身份认证失败，请联系管理员。";
        } catch (Exception e){
            map.clear();
            flag = false;
            code = StatusCode.ERROR;
            msg = "服务器错误，请联系程序猿修复BUG。";
        }
        Result result=new Result( flag, code, msg, map);
        return result;
    }

    /**
     * 用户查询
     * @param user
     * @return
     */
    @RequestMapping(value = "getUsers",produces = "application/json;charset=UTF-8")
    public Result getUsers(Account user){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag=true;
        Integer code=0;
        String msg="";

        try {
            List<Account> users=accountService.selectUsersByCon(user);
            map.put("users",users);
            flag=true;
            code=StatusCode.OK;
            msg="";
        } catch (Exception e){
            e.printStackTrace();
            map.clear();
            flag=false;
            code=StatusCode.ERROR;
            msg=e.getMessage();
        }
        return new Result(flag, code, msg, map);
    }

    /**
     * 获取图片
     * @param rp
     * @param fileName
     */
    @RequestMapping("/img/{fileName}")
    public void getImagesId(HttpServletResponse rp, @PathVariable String fileName) {
        String path4=path_img+fileName;
        String filePath=path4;
        File imageFile = new File(filePath);
        if (imageFile.exists()) {
            FileInputStream fis = null;
            OutputStream os = null;
            try {
                fis = new FileInputStream(imageFile);
                os = rp.getOutputStream();
                int count = 0;
                byte[] buffer = new byte[1024 * 8];//8M
                while ((count = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                    os.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * redis应用
     * @return
     */
    @RequestMapping("/redisShow")
    public Result redisShow(){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag=true;
        Integer code=0;
        String msg="";

        flag = true;
        code = StatusCode.OK;
        msg = "";

        redisUtil.set("ok","nb-ok");

        map.put("ok",redisUtil.get("name"));

        return new Result(flag, code, msg, map);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "updUser",produces = "application/json;charset=UTF-8")
    public Result updUser(Account user, BindingResult bindingResult){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag;
        Integer code;
        String msg;

        try {
            Integer rs=accountService.updateByPrimaryKeySelective(user);
            map.put("rs",rs);
            flag=true;
            code=StatusCode.OK;
            msg="";
        }catch (Exception e){
            e.printStackTrace();
            map.clear();
            flag=false;
            code=StatusCode.ERROR;
            msg=e.getMessage();
        }
        return new Result(flag, code, msg, map);
    }

    /**
     * 上传用户图片
     * @param file
     * @return
     */
    @RequestMapping(value = "updUserImg")
    public Result updUserImg(@RequestParam(value = "avatar") MultipartFile file){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag=true;
        Integer code=0;
        String msg="";

        //上传至服务器的地址
        String path=path_img;
        Random random=new Random();
        String name=String.valueOf(random.nextInt(100000))+file.getOriginalFilename();
        path+=name;

        try {
            File newFile =new File(path);
            file.transferTo(newFile);

            map.put("imgName",name);
        } catch (Exception e) {
            e.printStackTrace();
            msg=e.getMessage();
            flag=false;
            code=StatusCode.ERROR;
        }
        return new Result(flag, code, msg, map);
    }

    /**
     * 用户删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delUser/{id}")
    public Result delUser(@PathVariable Integer id){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag;
        Integer code;
        String msg;

        try {
            Integer rs=accountService.deleteByPrimaryKey(id);
            map.put("rs",rs);
            flag=true;
            code=StatusCode.OK;
            msg="";
        }catch (Exception e){
            e.printStackTrace();
            map.clear();
            flag=false;
            code=StatusCode.ERROR;
            msg=e.getMessage();
        }
        return new Result(flag, code, msg, map);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delUsers/{ids}")
    public Result delUsers(@PathVariable Integer[] ids){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag=true;
        Integer code=0;
        String msg="";

        try {
            Integer rs=accountService.deleteByPrimaryKeys(ids);
            map.put("rs",rs);
            flag=true;
            code=StatusCode.OK;
            msg="";
        }catch (Exception e){
            e.printStackTrace();
            map.clear();
            flag=false;
            code=StatusCode.ERROR;
            msg=e.getMessage();
        }
        return new Result(flag, code, msg, map);
    }

    /**
     * 用户添加
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/addUser",produces  = "application/json;charset=UTF-8")
    public Result addUser(Account user, BindingResult bindingResult){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag;
        Integer code;
        String msg;

        try {
            Integer rs=accountService.insertSelective(user);
            map.put("rs",rs);
            flag=true;
            code=StatusCode.OK;
            msg="";
        }catch (Exception e){
            e.printStackTrace();
            map.clear();
            flag=false;
            code=StatusCode.ERROR;
            msg=e.getMessage();
        }
        return new Result(flag, code, msg, map);
    }

    /**
     * 检查用户名是否存在
     * @param user
     * @return
     */
    @RequestMapping(value = "/checkUserName",produces  = "application/json;charset=UTF-8")
    public Result checkUserName(Account user){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag;
        Integer code;
        String msg;

        try {
            Integer rs=accountService.selectUserName(user);
            map.put("rs",rs);
            flag=true;
            code=StatusCode.OK;
            msg="";
        }catch (Exception e){
            e.printStackTrace();
            map.clear();
            flag=false;
            code=StatusCode.ERROR;
            msg=e.getMessage();
        }
        return new Result(flag, code, msg, map);
    }




    /**
     * test测试
     * @param nickname
     * @return
     */
    @RequestMapping(value = "/test/{nickname}", produces = "application/json;charset=UTF-8")
    public Result test(@PathVariable String nickname){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag=true;
        Integer code=0;
        String msg="";

        try {
            Integer rs = 1 ;
            map.put("rs",rs);
            flag=true;
            code=StatusCode.OK;
            msg="";
        } catch (Exception e){
            e.printStackTrace();
            map.clear();
            flag=false;
            code=StatusCode.ERROR;
            msg=e.getMessage();
        }

        return new Result(flag, code, msg, map);
    }

    /**
     * test测试 1
     * @return
     */
    @GetMapping(value = "mq/{data}")
    public Result mq(@PathVariable Object data){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag=true;
        Integer code=0;
        String msg="";

        try {
            rabbitSend.send(data);

            Integer rs = 1 ;
            map.put("rs",rs);
            flag=true;
            code=StatusCode.OK;
            msg="消息已发送，请查看！";
        } catch (Exception e){
            e.printStackTrace();
            map.clear();
            flag=false;
            code=StatusCode.ERROR;
            msg=e.getMessage();
        }

        return new Result(flag, code, msg, map);
    }
}
