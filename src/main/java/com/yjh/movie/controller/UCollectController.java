package com.yjh.movie.controller;


import com.yjh.movie.po.UCollect;
import com.yjh.movie.service.UCollectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping("/delc/{mid}")
    @ResponseBody
    public  String delC( @PathVariable("mid") String mid){

        int i = uCollectService.deteleC(mid);
        if(i == 1){
            return "ok";
        }
        return "no";
    }


    @RequestMapping(value = "/tousercollect/{uid}")
    public String tocollects(@PathVariable("uid") Integer uid, Model model){
        List<UCollect> list = uCollectService.findUCallbyID(uid);
        model.addAttribute("lists",list);
        return "userMainUcollect";
    }
    
    
}
