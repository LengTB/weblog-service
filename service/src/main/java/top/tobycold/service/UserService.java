package top.tobycold.service;

import top.tobycold.dto.UserDTO;
import top.tobycold.pojo.UserEntity;

/**
 * 用户表的操作类
 */
public interface UserService {

    /**
     * 删除用户
     * @param userEntity
     */
    void delete(UserEntity userEntity);

    /**
     * 修改用户
     * @param userEntity
     */
    void update(UserEntity userEntity);

    /**
     * 查询用户
     * @param userEntity
     */
    UserEntity select(UserEntity userEntity);

}
