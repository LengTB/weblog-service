package top.tobycold.service;

import top.tobycold.dto.IdentityDTO;
import top.tobycold.pojo.IdentityEntity;
import top.tobycold.pojo.UserEntity;
import top.tobycold.util.Result;

public interface IdentityService {
    /**
     * 身份查询
     * @param identityDTO
     * @return
     */
    Result<String> select(IdentityDTO identityDTO);
    /**
     * 身份添加
     * @param identityDTO
     */

    Result<String> insert(IdentityDTO identityDTO);
    /**
     * 身份修改
     * @param identityDTO
     */
    Result<String> update(IdentityDTO identityDTO);
    /**
     * 身份删除
     * @param identityDTO
     */
    Result<String> delete(IdentityDTO identityDTO);

}
