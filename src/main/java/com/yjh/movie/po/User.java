package com.yjh.movie.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@ToString
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
    private Date uregistertime;

}