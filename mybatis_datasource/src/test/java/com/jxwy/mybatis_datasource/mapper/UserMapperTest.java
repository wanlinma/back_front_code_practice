package com.jxwy.mybatis_datasource.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxwy.mybatis_datasource.eneity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testDS() {
        // 默认 master
        List<User> users = userMapper.selectList(new QueryWrapper<>());
        System.out.println(users);

        // slave_1
//        List<User> allMybatisPlus2 = userMapper.findAllMybatisPlus2();
//        System.out.println(allMybatisPlus2);
    }
}