package com.yjh.movie.service;

import com.yjh.movie.po.User;

import java.util.List;

public interface UserService {



    public List<User> findall();

    //登录
    public List<User> Login(String uphonenumber,String pwd,Integer ustatus);

    //注册
    public Integer addUser(String uemail,String uphonenumber,String pwd);

    //根据手机号查询
    public List<User> registerFindByPhone(String uphonenumber);

    //根据邮箱查询
    public List<User> registerFindByEmail(String ueamil);

    //根据手机号修改 密码
    public Integer updataUserByPhone(String uphonenumber,String upassword);

    //根据id修改邮箱
    public Integer updataEmailByid(String ueamil,String uid);

    //根据id修改name
    public Integer updataNAMEByid(String name,String uid);

    //全查

    public List<User> findUserall();

    //全查

    public List<User> findUserallbypage(Integer nowpage );

    //查总数

    public Integer userpageCount();

    // 更新status

    public int upuserstatus(int id ,int status);


}
