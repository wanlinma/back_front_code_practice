package com.jxwy.mybatis_datasource.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxwy.mybatis_datasource.eneity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
@DS("master")
public interface UserMapper extends BaseMapper<User> {

    @DS("slave_1")
    @Select("select * from user")
    public List<User> findAllMybatisPlus2();
}
