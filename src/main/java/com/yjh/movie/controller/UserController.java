package com.yjh.movie.controller;


import com.yjh.movie.po.User;
import com.yjh.movie.service.UserService;
import com.yjh.movie.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

}
