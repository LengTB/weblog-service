package top.tobycold.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.tobycold.pojo.UserEntity;

@Mapper
public interface UserMapper {

    /**
     * 添加用户 完整添加（完整添加就是可以根据任意字段添加用户）
     * @param userEntity
     */
    void insert(UserEntity userEntity);

    /**
     * 查询用户 完整查询（完整查询就是可以根据任意字段查询用户）
     * @param userEntity
     * @return
     */
    UserEntity select(UserEntity userEntity);

    /**
     * 删除用户 完整删除（完整删除就是可以根据任意字段删除用户）
     * @param userEntity
     */
    void delete(UserEntity userEntity);

    /**
     * 修改用户 完整修改（完整修改就是可以根据任意字段修改用户）
     * @param userEntity
     */
    void update(UserEntity userEntity);
}
