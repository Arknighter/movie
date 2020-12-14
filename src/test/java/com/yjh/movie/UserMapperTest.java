package com.yjh.movie;

import com.yjh.movie.Mapper.UserMapper;
import com.yjh.movie.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;


    //查询所有user
    @Test
    public void testFindAll(){
        List<User> users = userMapper.selectList(null);
        users.forEach(user -> System.out.println("user="+user));
    }


}
