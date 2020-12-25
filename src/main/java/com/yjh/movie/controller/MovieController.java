package com.yjh.movie.controller;


import com.yjh.movie.po.Movie;
import com.yjh.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Resource
    MovieService movieService;


    @RequestMapping(value = "findall")
    public String findall(Integer status, Model model){
        status = 0;
        List<Movie> movieList = movieService.findAll(status);
        model.addAttribute("movielist",movieList);
        return "freemarkertemp";
    }

}
