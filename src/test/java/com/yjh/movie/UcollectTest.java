package com.yjh.movie;

import com.yjh.movie.Mapper.UCollectMapper;
import com.yjh.movie.po.UCollect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UcollectTest {

    @Autowired
    UCollectMapper uCollectMapper;

    @Test
    public  void findall(){
        List<UCollect> lists = uCollectMapper.selectList(null);
        lists.forEach(uCollect -> System.out.println(uCollect));

    }

    //收藏
    @Test
    public  void add(){
        UCollect uCollect = new UCollect().builder()
                .mid("12312")
                .uid(12321)
                .mname("testname")
                .build();
        uCollectMapper.insert(uCollect);

    }
}
