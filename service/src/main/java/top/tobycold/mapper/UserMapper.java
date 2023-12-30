package top.tobycold.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.tobycold.pojo.UserEntity;

@Mapper
public interface UserMapper {

    /**
     * 根据account查询用户
     * @param account
     * @return
     */
    UserEntity getByAccount(String account);
}
