package com.jxwy.mybatis_datasource.eneity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "user")
public class User {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String age;
    private String email;
}
