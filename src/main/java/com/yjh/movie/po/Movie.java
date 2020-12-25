package com.yjh.movie.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class Movie {
    @TableId(value = "movie_id")
    private String movieid;
    @TableField(value = "movie_title")
    private String movietitle;
    @TableField(value = "movie_imgurl")
    private String movieimgurl;
    @TableField(value = "movie_director")
    private String moviedirector;
    @TableField(value = "movie_action")
    private String movieaction;
    @TableField(value = "movie_up_time")
    private String movieuptime;
    @TableField(value = "movie_time")
    private String movietime;
    @TableField(value = "movie_grade")
    private String moviegrade;
    @TableField(value = "movie_story")
    private String moviestory;
    @TableField(value = "movie_tid")
    private String movietid;
    @TableField(value = "movie_status")
    private Integer moviestatus;

}
