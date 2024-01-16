package top.tobycold.service;

import top.tobycold.dto.UserDTO;
import top.tobycold.pojo.UserEntity;

/**
 * 用户表的操作类
 */
public interface UserService {
    /**
     * 添加用户
     * @param userDTO
     */
    void insert(UserDTO userDTO);

    /**
     * 删除用户
     * @param userDTO
     */
    void delete(UserDTO userDTO);

    /**
     * 修改用户
     * @param userDTO
     */
    void update(UserDTO userDTO);

    /**
     * 查询用户
     * @param userDTO
     */
    UserEntity select(UserDTO userDTO);

}
