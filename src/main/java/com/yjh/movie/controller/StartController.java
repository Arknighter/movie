package com.yjh.movie.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {

    @RequestMapping("/")
    public String homePage() {
        return "userIndex";
    }

    @RequestMapping("/tomain")
    public String  toMain(){
        return "adminMain";
    }

    @RequestMapping("/tousermain")
    public String  toUserMain(){
        return "userMain";
    }

}
