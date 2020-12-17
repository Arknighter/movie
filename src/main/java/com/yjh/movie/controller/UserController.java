package com.yjh.movie.controller;

import com.yjh.movie.po.User;
import com.yjh.movie.service.UserService;
import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @GetMapping("/findall")
    public String findall(Model model){

        List<User> users = userService.findall();

        model.addAttribute("users",users);

        return "freemarkertemp";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    //登录  ulevel = 0; ustatus = 0; 普通用户 和 正常状态账号登录
    public String Login(Integer ulevel, Integer ustatus, HttpServletRequest request,HttpSession session){
        ulevel = 0; ustatus = 0;
        String email = request.getParameter("uname");
        String pwd = request.getParameter("upwd");
        List<User> users = userService.Login(email, pwd, ulevel, ustatus);
        //System.out.println(users);
        if (users.size()!= 0 && email != "" && pwd != "") {
           // model.addAttribute("users",users);
            session.setAttribute("users",users);
            System.out.println("成功进入");
            return "adminMain";
        }
        else
            System.out.println("进入失败");
            return "login";
    }


    //注销
    @RequestMapping("/logout")
    public  String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

}
