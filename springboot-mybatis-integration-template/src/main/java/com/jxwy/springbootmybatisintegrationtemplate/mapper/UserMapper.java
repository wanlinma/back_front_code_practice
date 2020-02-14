package com.jxwy.springbootmybatisintegrationtemplate.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxwy.springbootmybatisintegrationtemplate.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}