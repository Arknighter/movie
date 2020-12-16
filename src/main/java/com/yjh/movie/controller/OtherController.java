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

    @RequestMapping("/forgetpwd")
    public String  toForgetPWD(){
        return "forgetpwd";
    }

}
