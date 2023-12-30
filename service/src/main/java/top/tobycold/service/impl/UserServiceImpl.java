package top.tobycold.service.impl;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.dto.UserDTO;
import top.tobycold.mapper.UserMapper;
import top.tobycold.pojo.UserEntity;
import top.tobycold.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    /**
     * 添加用户
     * @param userDTO
     */
    public void insert(UserDTO userDTO){
        UserEntity user = UserEntity.builder().build();
        BeanUtil.copyProperties(userDTO, user);

        userMapper.insert(user);
    }

    /**
     * 删除用户
     * @param userDTO
     */
    public void delete(UserDTO userDTO){

    }

    /**
     * 修改用户
     * @param userDTO
     */
    public void update(UserDTO userDTO){

    }

    /**
     * 查询用户
     * @param userDTO
     */
    public UserEntity select(UserDTO userDTO){

        UserEntity user = UserEntity.builder()
                .build();
        BeanUtil.copyProperties(userDTO, user);

        UserEntity userEntity = userMapper.select(user);
        return userEntity;
    }

    /**
     * 根据id查询用户
     * @return
     */
    public UserEntity getById(Long id) {
        UserEntity user = UserEntity.builder().id(id).build();
        return userMapper.select(user);
    }
}
