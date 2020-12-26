package com.yjh.movie;


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

}
