package com.yjh.movie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
        queryWrapper.eq("movie_status","0");
        List<Movie> movieList = movieMapper.selectList(queryWrapper);

        return movieList;
    }
}
