package com.example.mybatisPlus.mapper.main;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisPlus.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM users WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

}
