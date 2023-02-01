package com.example.samplemybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyBatisTutorialRepository {

    @Select("select count(1) from tutorial")
    int count();
}
