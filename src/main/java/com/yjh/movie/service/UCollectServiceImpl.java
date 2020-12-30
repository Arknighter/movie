package com.yjh.movie.service;


import com.yjh.movie.Mapper.UCollectMapper;
import com.yjh.movie.po.UCollect;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UCollectServiceImpl implements UCollectService{

    @Resource
    private UCollectMapper uCollectMapper;

    @Override
    public int addC(int uid, String mid, String mname) {
        UCollect uCollect = new UCollect();
        uCollect.setUid(uid);
        uCollect.setMid(mid);
        uCollect.setMname(mname);

        return uCollectMapper.insert(uCollect);
    }
}
