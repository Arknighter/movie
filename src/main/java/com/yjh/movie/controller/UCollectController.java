package com.yjh.movie.controller;


import com.yjh.movie.service.UCollectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ucollect")
public class UCollectController {

    @Resource
    UCollectService uCollectService;
    
    @RequestMapping("/addc/{mid}/{uid}/{mname}")
    @ResponseBody
    public  String addC( @PathVariable("uid")int uid,@PathVariable("mid") String mid, @PathVariable("mname") String mname, HttpServletRequest request){

        int i = uCollectService.addC(uid, mid, mname);
        if(i == 1){
            return "ok";
        }
        return "no";
    }
    
    
    
}
