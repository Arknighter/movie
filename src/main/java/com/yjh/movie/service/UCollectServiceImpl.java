package com.yjh.movie.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yjh.movie.Mapper.UCollectMapper;
import com.yjh.movie.po.UCollect;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public int deteleC(String mid) {
        QueryWrapper<UCollect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mid",mid);
        return uCollectMapper.delete(queryWrapper);
    }

    @Override
    public List<UCollect> findUCallbyUID(String mid) {

        QueryWrapper<UCollect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mid",mid);
        return uCollectMapper.selectList(queryWrapper);
    }

    @Override
    public List<UCollect> findUCallbyID(Integer uid) {
        QueryWrapper<UCollect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid);
        return uCollectMapper.selectList(queryWrapper);
    }
}
