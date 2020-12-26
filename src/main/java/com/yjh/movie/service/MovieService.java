package com.yjh.movie.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yjh.movie.po.Movie;

import java.util.List;

public interface MovieService {

    //全查查询状态为0或者1的影片
    public List<Movie> findAll(Integer status);

    //全查查询状态为0或者1的影片 进行分页
    public List<Movie> findAllByPage(Integer status,Integer nowpage);

}
