package com.shixi.miaosha.controller;

import com.shixi.miaosha.dao.UserMapper;
import com.shixi.miaosha.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserMapper userDOMapper;

    @RequestMapping("/")
    public String home() {
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if (userDO == null) {
            return "用户信息不存在";
        } else {
            return userDO.getName();
        }
    }
}