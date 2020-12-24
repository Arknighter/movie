package com.yjh.movie.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yjh.movie.Mapper.UserMapper;
import com.yjh.movie.po.User;
import com.yjh.movie.utils.DozerUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;




    //全查
    @Override
    public List<User> findall() {
        List<User> users = userMapper.selectList(null);
        users.forEach(user -> System.out.println("user="+user));
        return DozerUtils.mapList(users,User.class);


    }

    //登录（根据用户名和密码查询用户）
    @Override
    public List<User> Login(String uphonenumber,String pwd,Integer ulevel,Integer ustatus) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uphonenumber",uphonenumber)
                .eq("upassword",pwd)
                .eq("ulevel",ulevel)
                .eq("ustatus",ustatus);
        List<User> users = userMapper.selectList(queryWrapper);

        return users;
    }

    @Override
    public Integer addUser(String uemail, String uphonenumber, String pwd) {
        //分割去出邮箱@前的用户名
        String[] split = uemail.split("@");
        String uname = split[0];
        User entity = new User().builder()
                .uemail(uemail)
                .uphonenumber(uphonenumber)
                .upassword(pwd)
                .uname(uname)
                .uregistertime(new Date())
                .build();
        int num = userMapper.insert(entity);
        return num;
    }

    @Override
    public List<User> registerFindByPhone(String uphonenumber) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("uphonenumber",uphonenumber);
        List<User> users = userMapper.selectList(userQueryWrapper);
        return users;
    }

    @Override
    public List<User> registerFindByEmail(String ueamil) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("uemail",ueamil);
        List<User> users = userMapper.selectList(userQueryWrapper);
        return users;
    }

    @Override
    public Integer updataUserByPhone(String uphonenumber, String upassword) {
        User user = new User();
        user.setUpassword(upassword);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("uphonenumber",uphonenumber);
        return  userMapper.update(user,userQueryWrapper);
    }


}
