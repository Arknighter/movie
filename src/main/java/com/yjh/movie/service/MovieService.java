package com.yjh.movie.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yjh.movie.po.Movie;
import com.yjh.movie.po.User;

import java.util.List;

public interface MovieService {

    //全查查询状态为0或者1的影片
    public List<Movie> findAll(Integer status);

    //全查查询状态为0或者1的影片 进行分页
    public List<Movie> findAllByPage(Integer status,Integer nowpage);

    //全查查询状态为0或者1的影片 统计
    public Long findAllByPageCount(Integer status,Integer nowpage);

    //全查所有影片 进行分页
    public List<Movie> findAllByPages(Integer nowpage);

    //根据movieid查询 电影
    public  List<Movie> findById(String id);

    //查询全部
    public Integer findCount();

    //查询下架影片
    public Integer findCountNOup(Integer status);

    //根据id下架影片
    public  int deleteMoviebyID(String id,Integer status);

    //根据更新信息
    public int updatamovie(String id,String story,String url,String title,String uptime,String director);

    //根据影片名模糊查询影片
    public List<Movie> findMovieLikeName(Integer nowpage, String name);

    //查总数 条件

    public Long movieLikepageCount(Integer nowpage,String name);

    //    填加电影
    public int addMovie(Movie movie);


}
