package com.example.mybatisPlus.mapper.edi;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisPlus.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TestMapper extends BaseMapper<User> {

    @Select("SELECT * FROM users WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

}
