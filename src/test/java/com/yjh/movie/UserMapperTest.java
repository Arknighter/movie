package com.yjh.movie;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yjh.movie.Mapper.UserMapper;
import com.yjh.movie.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
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
//        String codenumber = new FindPwdByPhone().Codenumber();
//        System.out.println(codenumber);

    }

    // 根据主键id查询
    @Test
    public void testFindbyID(){
        User user = userMapper.selectById("202002");

        System.out.println("User="+user);

    }

    //条件查询
    @Test
    public void testFind(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("upassword","123");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> System.out.println("user="+user));
    }

    //模糊查询
    @Test
    public  void  testFindLike(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("uemail","@qq.com");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> System.out.println("User="+user));
    }

    //保存记录
    @Test
    public void testSave(){
        User entity = new User().builder()
                .uregistertime(new Date())
                .uname("test0A")
                .uemail("test0A@test.com")
                .ulevel(0)
                .ustatus(0)
                .uphonenumber("111111111")
                .upassword("aaa").build();
//        entity.setUemail("20201@test.com");
//        entity.setUname("test02");
//        entity.setUpassword("11111");
//        entity.setUregistertime(new Date();
        userMapper.insert(entity);
    }

//    根据id修改
    @Test
    public void testUpdate(){
        User user = userMapper.selectById("202011");
        user.setUpassword("okok123");
        userMapper.updateById(user);
    }

    // 多项修改
    @Test
    public void testUpadtes(){
        User user = new User();
        user.setUpassword("new123");
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("uemail","1912455977@qq.com");
        userMapper.update(user,userQueryWrapper);
    }

    // 根据手机号修改密码
    @Test
    public void testUpadtebyphone(){
        User user = new User();
        user.setUpassword("7k7k7k");
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("uphonenumber","18970570854");
        userMapper.update(user,userQueryWrapper);
    }


    //删除 根据id
    @Test
    public void testDeleteById(){
        userMapper.deleteById("202009");
    }

    //基于条件进行删除
    @Test
    public  void testDelete(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("upassword","okok123");
        userMapper.delete(queryWrapper);

    }



}
