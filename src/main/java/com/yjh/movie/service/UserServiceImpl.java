package com.yjh.movie.service;


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





}
