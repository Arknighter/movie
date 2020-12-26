package com.yjh.movie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yjh.movie.Mapper.MovieMapper;
import com.yjh.movie.po.Movie;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Resource
    private MovieMapper movieMapper;

    @Override
    public List<Movie> findAll(Integer status) {

        QueryWrapper<Movie> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("movie_status",status);
        List<Movie> movieList = movieMapper.selectList(queryWrapper);

        return movieList;
    }

    @Override
    public List<Movie> findAllByPage(Integer status,Integer nowpage) {
        IPage<Movie> page = new Page<>(nowpage,30);
        QueryWrapper<Movie> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("movie_status",status);
        IPage<Movie> movieIPage = movieMapper.selectPage(page, objectQueryWrapper);
        return movieIPage.getRecords();
    }
}
