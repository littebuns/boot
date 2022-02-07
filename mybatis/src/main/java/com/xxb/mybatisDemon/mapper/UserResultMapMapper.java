package com.xxb.mybatisDemon.mapper;

import com.xxb.mybatisDemon.entity.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserResultMapMapper {

    User selectByResultMapper(int id);

}
