package com.yjh.movie.controller;

import com.yjh.movie.po.User;
import com.yjh.movie.service.UserService;
import com.yjh.movie.utils.ReturnCode;
import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Resource
    UserService userService;

    @RequestMapping("/find404")
    @ResponseBody
    public String NoGet404(){
            return "404 sorry";
    }


//    @GetMapping("/findall")
//    public String findall(Model model){
//
//        List<User> users = userService.findall();
//
//        model.addAttribute("users",users);
//
//        return "freemarkertemp";
//    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    //登录 普通用户（level = 0） 和 正常状态账号登录（level = 1）
    public String Login( Integer ustatus, HttpServletRequest request,HttpSession session){
        ustatus = 0;//正常用户
        int level = 0;
        String uphonenumber = request.getParameter("uname");
        String pwd = request.getParameter("upwd");
        List<User> users = userService.Login(uphonenumber, pwd, ustatus);
        for (User user:users) {
          level =  user.getUlevel();
        }

        //System.out.println(users);
        if (users.size()!= 0 && uphonenumber != "" && pwd != "" && level == 1) {
           // model.addAttribute("users",users);
            session.setAttribute("users",users);
            System.out.println("成功进入管理员界面");
            return "adminMain";
        }else if(users.size()!= 0 && uphonenumber != "" && pwd != "" && level == 0) {
            // model.addAttribute("users",users);
            session.setAttribute("users", users);
            System.out.println("成功进入普通用户界面");
            return "/movie/findall";
        }
        else
            System.out.println("进入失败");
            return "login";
    }



    @RequestMapping(value = "/loginajax",method = RequestMethod.POST)
    @ResponseBody
    //登录 普通用户（level = 0） 和 正常状态账号登录（level = 1）
    public String Loginajax( Integer ustatus, String uphonenumber,  String pwd,HttpServletRequest request,HttpSession session){
        ustatus = 0;//正常用户
        int level = 0;
        List<User> users = userService.Login(uphonenumber, pwd, ustatus);
        for (User user:users) {
            level =  user.getUlevel();
        }
        //System.out.println(users);
        if (users.size()!= 0 && uphonenumber != "" && pwd != "" && level == 1) {
            // model.addAttribute("users",users);
            session.setAttribute("users",users);
            System.out.println("成功进入管理员界面");
            return "admin";
        }else if(users.size()!= 0 && uphonenumber != "" && pwd != "" && level == 0) {
            // model.addAttribute("users",users);
            session.setAttribute("users", users);
            System.out.println("成功进入普通用户界面");
            return "user";
        }
        else
            System.out.println("进入失败");
        return "no";
    }




    //注销
    @RequestMapping("/logout")
    public  String logout(HttpSession session){
        session.invalidate();
        return "login";
    }



    //注册 密码不相同用ajax做
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(String uemail,String uphonenumber,String pwd){
      // System.out.println("============"+pwd);
        List<User> users = userService.registerFindByPhone(uphonenumber);
        List<User> users1 = userService.registerFindByEmail(uemail);
        if(users.size()>0 || users1.size()>0){
            return "no";
        }else if (pwd != null && pwd !=""){
            Integer  num  = userService.addUser(uemail, uphonenumber, pwd);
            if (num == 1){
                return "ok";
            }
        }
        return "no";

    }

    //根据电话查询
    @RequestMapping(value = "/findphone",method = RequestMethod.POST)
    @ResponseBody
    public String findbyPhone(String phonenumber){
        List<User> userList = userService.registerFindByPhone(phonenumber);
        if(userList.size()>0){
            return "ok";
        }
        return "no";
    }

    //根据邮箱查询
    @RequestMapping(value = "/findemail",method = RequestMethod.POST)
    @ResponseBody
    public String findbyEmail(String email){
        List<User> userList = userService.registerFindByEmail(email);
        if(userList.size()>0){
            return "ok";
        }
        return "no";
    }

    //根据邮箱查询
    @RequestMapping(value = "/findemailpro/{email}")
    public String findbyEmailpro(@PathVariable("email") String email,Model model){
        List<User> userList = userService.registerFindByEmail(email);
        model.addAttribute("users",userList);
        if(userList.size()>0){
            return "userMain";
        }
        return "";
    }


    //根据id修改邮箱
    @RequestMapping(value = "/updataemailbyid",method = RequestMethod.POST)
    @ResponseBody
    public String updateEmailbyid(String email,String id){
        Integer integer = userService.updataEmailByid(email, id);
        if (integer == 1){
            return "ok";
        }

        return "no";
    }


    //根据id修改用户名
    @RequestMapping(value = "/updataenamebyid",method = RequestMethod.POST)
    @ResponseBody
    public String updateNAMEbyid(String name,String id,String email,Model model){
        Integer integer = userService.updataNAMEByid(name, id);
        List<User> users = userService.registerFindByEmail(email);
        for (User user: users) {
            String uname = user.getUname()+"(前台重新登录后名字生效)";
            user.setUname(uname);
        }
        model.addAttribute("users",users);
        if (integer == 1){
            return "ok";
        }
        return "no";
    }



    //用于验证
    String codenumber;
    //发送验证码
    @RequestMapping(value = "/sendSMS",method = RequestMethod.POST)
    @ResponseBody
    public  String sendSMS(String phonenumber){

        // 直接本地模拟发送
        String code = new ReturnCode().sendSmsNOaliyun(phonenumber);
        //利用阿里云发送短信 需要付费
        //String code = new ReturnCode().sendSms(phonenumber);

        codenumber = code;
        //System.out.println(codenumber+code);
        if (code!=null){
            return "ok";
        }
        return "no";
    }

    //得到前段写的验证码 本页面跳转
    @RequestMapping(value = "/code",method = RequestMethod.POST)
    @ResponseBody
    public  String code(String code){
        if(codenumber.equals(code)){
            codenumber ="";
            return "ok";

        }
        return "no";
    }

    //验证验证码然后根据手机号改密码
    @RequestMapping(value = "/checkSMS",method = RequestMethod.POST)
    @ResponseBody
    public String updataUserByPhone(String phonenumber,String pwd){
        Integer integer = userService.updataUserByPhone(phonenumber, pwd);
        if (integer == 1){
            return "ok";
        }

    return "no";

    }


}
