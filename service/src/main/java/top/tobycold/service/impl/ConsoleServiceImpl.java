package top.tobycold.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.dto.UserDTO;
import top.tobycold.mapper.UserMapper;
import top.tobycold.pojo.UserEntity;
import top.tobycold.service.ConsoleService;

@Service
public class ConsoleServiceImpl implements ConsoleService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param userDTO
     * @return
     */

    public UserEntity login(UserDTO userDTO) {
        return userMapper.getByAccount(userDTO.getAccount());
    }

    /**
     * 注册
     * @param userDTO
     * @return
     */
    public void registered(UserDTO userDTO) {

    }
}
