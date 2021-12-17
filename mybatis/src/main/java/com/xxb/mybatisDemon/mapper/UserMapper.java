package com.xxb.mybatisDemon.mapper;

import com.xxb.mybatisDemon.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

    User selectUser(int id);

    void insertUser(String name);

    int addUser(User user);

    /**
     * 将用户放置在map中
     * @return hashMap
     */
    @MapKey("id")
    Map<String, Object> selectUserToMap();

}
