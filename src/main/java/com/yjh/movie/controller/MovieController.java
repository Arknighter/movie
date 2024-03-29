package com.yjh.movie.controller;


import com.yjh.movie.po.Movie;
import com.yjh.movie.po.UCollect;
import com.yjh.movie.service.MovieService;
import com.yjh.movie.service.UCollectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Resource
    MovieService movieService;
    @Resource
    UCollectService uCollectService;


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
        model.addAttribute("nowpage",nowpage);
        model.addAttribute("num",num);
        System.out.println("总页数："+num +"当前页数："+nowpage);
        return "userIndex";
    }

    @RequestMapping(value = "/main/{movieid}")
    public String tomovieMain(@PathVariable("movieid") String id,Model model){

        List<Movie> movieList = movieService.findById(id);
        List<UCollect> collectList = uCollectService.findUCallbyUID(id);
        model.addAttribute("collectList",collectList);
        for (Movie movie: movieList) {
            if(movie.getMoviestory().length()>50){
                String story = movie.getMoviestory().substring(0,50)+"....";
                movie.setMoviestory(story);
            }

        }
        model.addAttribute("movies",movieList);
        return "userIndex";
    }

    @RequestMapping("/movieCount")
    public String findCount(Model model){
        Integer count = movieService.findCount();
        Integer noupnum = movieService.findCountNOup(1);
        model.addAttribute("count",count);
        model.addAttribute("noupnum",noupnum);
        return "adminMain";
    }

    //去影片库
    @RequestMapping("/toMAINmoive/page/{nopage}")
    public String toMAINmoive(@PathVariable("nopage") Integer nopage,Model model){
        //nopage=1;
        List<Movie> movieList = movieService.findAllByPages(nopage);
        Integer count = movieService.findCount();//总数
        int Pagenums = count/10+1;
        model.addAttribute("nowpage",nopage);
        model.addAttribute("Pagenums",Pagenums);
        model.addAttribute("count",count);
        model.addAttribute("movieList",movieList);
        return "adminMainMovies";
    }


    //影片名字查影片库
    @RequestMapping("/likemoive/{name}/{nopage}")
    public String toMAINmoive(@PathVariable("nopage") Integer nopage,@PathVariable("name") String name,Model model){
        //nopage=1;
        List<Movie> movieList = movieService.findMovieLikeName(nopage,name);
        Long count = movieService.movieLikepageCount(nopage, name);
        int Pagenums = (int) (count/10+1);
        model.addAttribute("nowpage",nopage);
        model.addAttribute("Pagenums",Pagenums);
        model.addAttribute("count",count);
        model.addAttribute("movieList",movieList);
        return "adminMainMovies";
    }





    //根据id找到影片 显示出来
    @RequestMapping(value = "/find/{id}")
    public String upfindMovieById(@PathVariable("id") String id,Model model){

        List<Movie> movies = movieService.findById(id);
        System.out.println("================="+movies);
       if (movies.size()>0){
           model.addAttribute("upmoviemsg",movies);
           return "/movie/toUPmoive";
       }else{
           return "/movie/toMAINmoive/page/1";
       }

    }

    // 根据id 更新movie
    @RequestMapping("/update")
    @ResponseBody
    public String updetaMovie(String id,String story,String url,String title,String uptime,String director){

        int i = movieService.updatamovie(id, story, url, title, uptime, director);

        if (i == 1){
            return "ok";
        }
        return "no";
    }

    //删除影片  stauts变1
    @RequestMapping("/delete/id/{id}")
    public  String deteleBYId(@PathVariable("id") String id){

        int i = movieService.deleteMoviebyID(id, 1);

        return "/movie/toMAINmoive/page/1";
    }

    //上架影片  stauts变0
    @RequestMapping("/upmovie/id/{id}")
    public  String upmovieBYId(@PathVariable("id") String id){

        int i = movieService.deleteMoviebyID(id, 0);

        return "/movie/toMAINmoive/page/1";
    }

    @RequestMapping("/addmovies")
    @ResponseBody
    public String addmovies(Movie movie){
        int newid = (int)((Math.random()*99999999)+1000000);
        String id = String.valueOf(newid);
        movie.setMovieid(id);
        movie.setMoviestatus(0);
        movie.setMoviegrade("10");
        movie.setMovietid("1");
        int i = movieService.addMovie(movie);
        if (i==1){
            return "ok";
        }
        return "no";
    }


    @RequestMapping("/toADDmoive")
    public String toADDmoive(){

        return "adminMainaddMovies";
    }

    @RequestMapping("/toMAINUser")
    public String toMAINUser(){

        return "/user/findall/page/1";
    }

    @RequestMapping("/toUPmoive")
    public String toUPmoive(){

        return "adminMainMoviesupdate";
    }

}
