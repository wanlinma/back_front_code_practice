package com.jxwy.springbootmybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxwy.springbootmybatisplusdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
