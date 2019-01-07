package com.gyb.mybatis.mapper;

import com.gyb.mybatis.entity.User;

import java.util.List;

public interface TestMapper {

    public User selectById(int id);

    List<User> selectAll();
}
