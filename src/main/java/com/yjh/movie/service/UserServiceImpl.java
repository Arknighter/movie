package com.yjh.movie.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yjh.movie.Mapper.UserMapper;
import com.yjh.movie.po.User;
import com.yjh.movie.utils.DozerUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public List<User> Login(String email,String pwd,Integer ulevel,Integer ustatus) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uemail",email)
                .eq("upassword",pwd)
                .eq("ulevel",ulevel)
                .eq("ustatus",ustatus);
        List<User> users = userMapper.selectList(queryWrapper);

        return users;
    }


}
