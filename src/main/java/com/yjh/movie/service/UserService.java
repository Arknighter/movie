package com.yjh.movie.service;

import com.yjh.movie.po.User;

import java.util.List;

public interface UserService {



    public List<User> findall();

    //登录
    public List<User> Login(String uphonenumber,String pwd,Integer ulevel,Integer ustatus);

    //注册
    public Integer addUser(String uemail,String uphonenumber,String pwd);

    //根据手机号查询
    public List<User> registerFindByPhone(String uphonenumber);

    //估计邮箱查询
    public List<User> registerFindByEmail(String ueamil);

    //根据手机号修改 密码
    public Integer updataUserByPhone(String uphonenumber,String upassword);

}
