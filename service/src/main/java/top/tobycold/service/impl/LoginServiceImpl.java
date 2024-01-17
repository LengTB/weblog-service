package top.tobycold.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tobycold.admin.IdentityName;
import top.tobycold.admin.LoginStatus;
import top.tobycold.dto.LoginDTO;
import top.tobycold.mapper.UserMapper;
import top.tobycold.pojo.UserEntity;
import top.tobycold.service.LoginService;
import top.tobycold.util.ColdUtil;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 登录接口
     *
     * @param loginDTO
     * @return
     */
    public LoginStatus login(LoginDTO loginDTO) {
        try {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(loginDTO, userEntity);
            UserEntity userEntityResult = userMapper.select(userEntity);
            ColdUtil.isNull(userEntityResult).trueOrFalseHandler(() -> {
                throw new RuntimeException("用户不存在");
            }, ()->{});
            return LoginStatus.SUCCESS;
        } catch (Exception ex) {
            return LoginStatus.ERROR;
        }
    }

    /**
     * 注册接口
     *
     * @param loginDTO
     * @return
     */
    @Transactional
    public LoginStatus register(LoginDTO loginDTO) {
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            Object obj = valueOperations.get(loginDTO.getEmail());

            ColdUtil.isNull(obj).trueOrFalseHandler(() -> {
                throw new RuntimeException("验证码已失效");
            }, () -> {});

            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(loginDTO, userEntity);

            UserEntity userEntityResult = userMapper.select(userEntity);
            ColdUtil.isNull(userEntityResult).trueOrFalseHandler(() -> {
                    },
                    () -> {
                        throw new RuntimeException("用户已存在");
                    });

            userEntity.setName(loginDTO.getAccount());
            userEntity.setIdentity(IdentityName.USER.getName());
            userEntity.setGrade("0");
            userMapper.insert(userEntity);
            return LoginStatus.SUCCESS;
        } catch (Exception ex) {
            return LoginStatus.ERROR;
        }
    }
}
