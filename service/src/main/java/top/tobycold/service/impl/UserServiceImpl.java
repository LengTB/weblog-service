package top.tobycold.service.impl;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.mapper.UserMapper;
import top.tobycold.pojo.UserEntity;
import top.tobycold.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 删除用户
     * @param userEntity
     */
    public void delete(UserEntity userEntity){

    }

    /**
     * 修改用户
     * @param userEntity
     */
    public void update(UserEntity userEntity){

    }

    /**
     * 查询用户
     * @param userEntity
     */
    public UserEntity select(UserEntity userEntity){

       return null;
    }

}
