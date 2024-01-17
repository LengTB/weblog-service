package top.tobycold.service;

import top.tobycold.admin.LoginStatus;
import top.tobycold.dto.LoginDTO;

public interface LoginService {
    /**
     * 登录接口
     * @param loginDTO
     * @return
     */
    LoginStatus login(LoginDTO loginDTO);

    /**
     * 注册接口
     * @param loginDTO
     * @return
     */

    LoginStatus register(LoginDTO loginDTO);
}
