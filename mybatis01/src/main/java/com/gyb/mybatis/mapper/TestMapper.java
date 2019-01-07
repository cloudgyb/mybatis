package com.gyb.mybatis.mapper;

import com.gyb.mybatis.entity.User;

import java.util.List;

public interface TestMapper {

    User selectById(int id);

    List<User> selectAll();
}
