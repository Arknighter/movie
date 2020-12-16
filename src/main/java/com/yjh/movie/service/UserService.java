package com.yjh.movie.service;

import com.yjh.movie.po.User;

import java.util.List;

public interface UserService {



    public List<User> findall();

    //登录
    public List<User> Login(String emil,String pwd,Integer ulevel,Integer ustatus);
}
