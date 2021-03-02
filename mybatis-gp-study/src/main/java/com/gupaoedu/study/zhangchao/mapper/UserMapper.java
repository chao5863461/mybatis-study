package com.gupaoedu.study.zhangchao.mapper;

import com.gupaoedu.study.zhangchao.model.User;

import java.util.List;

public interface UserMapper {

    public List<User> queryAll();

    public User getById(int id);

    public List<User> getByParams(User user);

    public void updateByPrimaryKey(User user);

    public void insertUser(User user);


}
