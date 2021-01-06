package com.shixi.miaosha.service;


import com.shixi.miaosha.dao.UserMapper;
import com.shixi.miaosha.dao.UserPasswordMapper;
import com.shixi.miaosha.dataobject.UserDO;
import com.shixi.miaosha.dataobject.UserPasswordDO;
import com.shixi.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPasswordMapper userPasswordMapper;

    @Override
    public UserModel getUserById(Integer id) {
        //调用UserDoMapper获取对应的用户dataobject
        UserDO userDO = userMapper.selectByPrimaryKey(id);
        if (userDO == null) {
            return null;
        }
        //通过用户id获取对应的用户加密密码信息
        UserPasswordDO userPasswordDO = userPasswordMapper.selectByUserId(userDO.getId());

        return convertFromDataObject(userDO, userPasswordDO);
    }

    //改造UserPasswordDaoMapper的方法，在xml配置文件中修改


    //通过UserDO和UserPasswordDO完美组装成UserModel
    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO) {
        if (userDO == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);
        if (userPasswordDO != null) {
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        }

        return userModel;

    }
}
