package com.xxb.mybatisDemon.mapper;

import com.xxb.mybatisDemon.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

    /**
     * 查询单个用户 (查询到多个会报错)
     */
    User selectUser(int id);

    /**
     * 通过 resultMap 映射结果集
     * @param id
     * @return
     */
    User selectUserByResultMap(int id);

    void insertUser(String name);

    int addUser(User user);

    /**
     * 将用户放置在map中
     * @return hashMap
     */
    @MapKey("id")
    Map<String, Object> selectUserToMap();

}
