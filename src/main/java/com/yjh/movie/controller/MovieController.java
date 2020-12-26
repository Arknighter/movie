package com.yjh.movie.controller;


import com.yjh.movie.po.Movie;
import com.yjh.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Resource
    MovieService movieService;


    @RequestMapping(value = "/findall")
    public String findall(Integer status, Model model){
        status = 0;
        List<Movie> movieList = movieService.findAll(status);
//        for (Movie movies : movieList) {
//          String story =  movies.getMoviestory().substring(0,20)+"...";
//          movies.setMoviestory(story);
//        }
        model.addAttribute("movielist",movieList);
        return "userIndex";
        //return "freemarkertemp";
    }


    @RequestMapping(value = "/findallbypage/{nowpage}")
    public String findallbypage(@PathVariable("nowpage") Integer nowpage,  Integer status, Model model){
        status=0;
        //nowpage=1;
        List<Movie> movieList = movieService.findAllByPage(status, nowpage);
        Long pageCount = movieService.findAllByPageCount(status, nowpage);//总数据
        int pageCounts = Math.toIntExact(pageCount);
        int num = pageCounts/30+1;
        model.addAttribute("movielist",movieList);
        System.out.println("总页数："+num +"当前页数："+nowpage);
        return "userIndex";
    }

    @RequestMapping(value = "/main/{movieid}")
    public String tomovieMain(@PathVariable("movieid") String id,Model model){

        List<Movie> movieList = movieService.findById(id);
        for (Movie movie: movieList) {
            if(movie.getMoviestory().length()>25){
                String story = movie.getMoviestory().substring(0,65)+"....";
                movie.setMoviestory(story);
            }

        }
        model.addAttribute("movies",movieList);
        return "userIndex";
    }


}
