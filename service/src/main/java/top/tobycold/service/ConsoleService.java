package top.tobycold.service;


import top.tobycold.dto.UserDTO;
import top.tobycold.pojo.UserEntity;

public interface ConsoleService {

    /**
     * 登录
     * @param userDTO
     */
    UserEntity login(UserDTO userDTO);
    /**
     * 注册
     * @param userDTO
     */

    void registered(UserDTO userDTO);
}
