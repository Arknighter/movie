package com.yjh.movie;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yjh.movie.Mapper.MovieMapper;
import com.yjh.movie.po.Movie;
import com.yjh.movie.utils.DozerUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MoiveMapperTest {

    @Autowired
   private MovieMapper movieMapper;


    @Test
    public  void tt(){
        String newid = String.valueOf(((Math.random()*999999999)+100000000));
        System.out.println(newid);
    }

    @Test
    public void FindAll(){
        List<Movie> movies = movieMapper.selectList(null);
        movies.forEach(movie -> System.out.println("movie"+movie));
    }

    @Test
    public void FindAllByPage(){
        //默认参数1  当前页    参数2 每页显示记录数
        IPage<Movie> page = new Page<>(2,10);
        IPage<Movie> movieIPage = movieMapper.selectPage(page, null);
        long total = movieIPage.getTotal();
        System.out.println("总记录数："+total);
        movieIPage.getRecords().forEach(movie -> System.out.println("movie"+movie));
    }

    @Test
    public void FindByid(){
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("movie_id","26694926");
        List<Movie> movieList = movieMapper.selectList(queryWrapper);
        movieList.forEach(movie -> System.out.println("move="+movie));
    }


    @Test
    public void insertMovie(){

        Movie movie = new Movie().builder()
                .movieaction("主演1")
                .movieid("1111112")//
                .moviegrade("7.2")//
                .moviedirector("导演1")
                .movieimgurl("xxxxx.jpg")
                .movietime("146分钟")
                .movietitle("我的测试aa")
                .movieuptime("2020-02-12(中国)")
                .movietid("1")//
                .moviestatus(0)//
                .moviestory("这个测试简介")
                .build();
        movieMapper.insert(movie);
    }

}
