package com.xxb.mybatisDemon.mapper;

import com.xxb.mybatisDemon.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 查询单个用户 (查询到多个会报错)
     */
    User selectUser(int id);

    /**
     * 根据年份查询用户
     * @param year
     * @return
     */
    List<User> selectUserByYear(String year);

    /**
     * 通过 resultMap 映射结果集
     * @param id
     * @return
     */
    User selectUserByResultMap(int id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 将用户放置在map中
     * @return hashMap
     */
    @MapKey("id")
    Map<String, Object> selectUserToMap();

}
