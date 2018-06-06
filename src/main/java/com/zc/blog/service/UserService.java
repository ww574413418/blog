package com.zc.blog.service;

import com.zc.blog.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public interface UserService extends CrudRepository<User,Long> {
    /*// 创建或修改用户
    User SaveOrUpdateUser(User user);

    // 删除用户
    void deleteUser(Long id);

    // 查询用户
    User getUserById(Long id);

    // 获取用户列表
    List<User> listUser();*/
}
