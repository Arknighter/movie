package com.yjh.movie.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class User {

    @TableId
    private int uid;

    private String uname;
    private String uemail;
    private String upassword;
    private int ulevel;
    private String uphonenumber;
    private int ustatus;
    private String uimg;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    private Date uregistertime;

}
