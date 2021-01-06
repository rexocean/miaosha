package com.shixi.miaosha.service;

import com.shixi.miaosha.service.model.UserModel;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    //通过用户id获取用户对象的方法
    UserModel getUserById(Integer id);
}
