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
        movieIPage.getTotal();
        return movieIPage.getRecords();
    }

    @Override
    public Long findAllByPageCount(Integer status, Integer nowpage) {
        IPage<Movie> page = new Page<>(nowpage,30);
        QueryWrapper<Movie> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("movie_status",status);
        IPage<Movie> movieIPage = movieMapper.selectPage(page, objectQueryWrapper);
        return  movieIPage.getTotal();
    }

    @Override
    public List<Movie> findAllByPages(Integer nowpage) {
        IPage<Movie> page = new Page<>(nowpage,10);
        IPage<Movie> movieIPage = movieMapper.selectPage(page, null);
        return movieIPage.getRecords();
    }


    @Override
    public List<Movie> findById(String id) {
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("movie_id",id);
        List<Movie> movieList = movieMapper.selectList(queryWrapper);
        return movieList;
    }

    @Override
    public Integer findCount() {

        return movieMapper.selectCount(null);
    }

    @Override
    public Integer findCountNOup(Integer status) {
        QueryWrapper<Movie> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("movie_status",status);
        return movieMapper.selectCount(objectQueryWrapper);
    }

    @Override
    public int deleteMoviebyID(String id,Integer Status) {
        Movie movie = new Movie();
        movie.setMovieid(id);
        movie.setMoviestatus(Status);
       return movieMapper.updateById(movie);
    }

    @Override
    public int updatamovie(String id,String story,String url,String title,String uptime,String director) {
        Movie movie = new Movie();
        movie.setMovieid(id);
        movie.setMoviestory(story);
        movie.setMovieimgurl(url);
        movie.setMovietitle(title);
        movie.setMovieuptime(uptime);
        movie.setMoviedirector(director);
        return movieMapper.updateById(movie);
    }
}
