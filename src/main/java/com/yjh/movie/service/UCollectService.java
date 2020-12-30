package com.yjh.movie.service;

import com.yjh.movie.po.UCollect;

import java.util.List;

public interface UCollectService {

    //查找

    //收藏影片
    public int addC(int uid,String mid,String mname);

    //取消收藏影片  直接删除吧
    public int deteleC(String mid);

    //根据mid查询   打错了不是uid 是mid
    public List<UCollect> findUCallbyUID(String mid);

    //根据uid查询
    public List<UCollect> findUCallbyID(Integer uid);

}
