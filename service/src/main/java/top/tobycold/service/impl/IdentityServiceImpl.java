package top.tobycold.service.impl;

import cn.hutool.jwt.JWT;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.admin.JwtConfig;
import top.tobycold.dto.IdentityDTO;
import top.tobycold.mapper.IdentityMapper;
import top.tobycold.pojo.IdentityEntity;
import top.tobycold.service.IdentityService;
import top.tobycold.util.Result;

import java.util.Date;

@Service
public class IdentityServiceImpl implements IdentityService {

    @Autowired
    IdentityMapper identityMapper;

    /**
     * 身份查询
     *
     * @param identityDTO
     * @return
     */
    public Result<String> select(IdentityDTO identityDTO) {
        IdentityEntity identity = new IdentityEntity();
        BeanUtils.copyProperties(identityDTO, identity);

        IdentityEntity identityEntity = identityMapper.select(identity);

        if (identityEntity == null) {
            return Result.error("账号或密码错误");
        }
        String token = JWT.create()
                .setExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))  //失效时间 -> 两个小时
                .setKey(JwtConfig.TOKEN_KEY.getBytes())
                .setPayload("name", identity.getName())
                .sign();
        if (identityEntity.getAccount().equals(identityDTO.getAccount())) {
            return Result.success("登录成功", token);
        }
        return Result.error("账号或密码错误");
    }

    /**
     * 身份添加
     *
     * @param identityDTO
     */
    public Result<String> insert(IdentityDTO identityDTO) {
        IdentityEntity identity = new IdentityEntity();
        BeanUtils.copyProperties(identityDTO, identity);
        try {

            identityMapper.insert(identity);
        } catch (Exception e) {
            return Result.error("创建失败");
        }
        return Result.success("创建成功");
    }

    /**
     * 身份修改
     *
     * @param identityDTO
     */
    public Result<String> update(IdentityDTO identityDTO) {
        IdentityEntity identity = new IdentityEntity();
        BeanUtils.copyProperties(identityDTO, identity);
        try {
            identityMapper.update(identity);
        }catch (Exception e){
            return Result.error("修改失败");
        }
        return Result.success("修改成功");
    }

    /**
     * 身份删除
     *
     * @param identityDTO
     */
    public Result<String> delete(IdentityDTO identityDTO) {
        IdentityEntity identity = new IdentityEntity();
        BeanUtils.copyProperties(identityDTO, identity);
        try {
            identityMapper.delete(identity);
        }catch (Exception e){
            return Result.error("删除失败");
        }
        return Result.success("删除成功");
    }
}
