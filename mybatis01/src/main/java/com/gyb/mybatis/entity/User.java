package com.gyb.mybatis.entity;


import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("User")
public class User {
    private int id;
    private String name;
    private byte sex;
}
