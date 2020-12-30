package com.yjh.movie.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("usercollect")
public class UCollect {
    @TableId(value = "id")
    private  int id;
    @TableField(value = "uid")
    private  int uid;
    @TableField(value = "mid")
    private String mid;
    @TableField(value = "mname")
    private String mname;
    @TableField(value = "cstatus")
    private String cstatus;
}
