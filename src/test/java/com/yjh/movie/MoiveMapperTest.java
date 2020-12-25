package com.yjh.movie;


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

}
