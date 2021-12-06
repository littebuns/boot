package com.xxb.mybatisDemon.mapper;

import com.xxb.mybatisDemon.entity.User;

public interface UserMapper {

    User selectUser(int id);

    void insertUser(String name);

    int addUser(User user);

}
