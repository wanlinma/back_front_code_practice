package com.jxwy.springbootmybatisplusdemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxwy.springbootmybatisplusdemo.entity.User;
import com.jxwy.springbootmybatisplusdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void pageCustom() {
        userMapper.selectOne(new QueryWrapper<>());
    }
}