package com.yjh.movie.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class OtherController {

    @RequestMapping("/login")
    public String  toLogin(){
        return "login";
    }

    @RequestMapping("/index")
    public String  toIndex(){
        return "userIndex";
    }

    @RequestMapping("/forgetpwd")
    public String  toForgetPWD(){
        return "forgetpwd";
    }

}
