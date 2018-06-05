package com.zc.blog.service;

import com.zc.blog.pojo.User;

import java.util.List;

public interface UserService {
    // 创建或修改用户
    User SaveOrUpdateUser(User user);

    // 删除用户
    void deleteUser(Long id);

    // 查询用户
    User getUserById(Long id);

    // 获取用户列表
    List<User> listUser();
}
