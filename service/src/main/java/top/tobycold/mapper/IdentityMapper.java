package top.tobycold.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.tobycold.pojo.IdentityEntity;
import top.tobycold.pojo.UserEntity;

@Mapper
public interface IdentityMapper {
    /**
     * 添加
     * @param identityEntity
     */
    void insert(IdentityEntity identityEntity);

    /**
     * 查询
     * @param identityEntity
     * @return
     */
    IdentityEntity select(IdentityEntity identityEntity);

    /**
     * 删除
     * @param identityEntity
     */
    void delete(IdentityEntity identityEntity);

    /**
     * 修改
     * @param identityEntity
     */
    void update(IdentityEntity identityEntity);
}
