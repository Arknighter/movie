package com.yjh.movie.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
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
