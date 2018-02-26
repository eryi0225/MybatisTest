package com.yiibai.mybatis.dao;

import com.yiibai.mybatis.models.User;

import java.util.List;

public interface IUser {
    public List<User> getUserList();

    public void insertUser(User user);

    public void UpdateUser(User user);

    public void delete(int userId);

    public  User getUser(int uuserId);
}
