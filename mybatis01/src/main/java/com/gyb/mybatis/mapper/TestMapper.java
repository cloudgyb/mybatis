package com.gyb.mybatis.mapper;

import com.gyb.mybatis.entity.User;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestMapper {

    User selectById(int id);

    @Select("select * from t_user")
    List<User> selectAll();
}
