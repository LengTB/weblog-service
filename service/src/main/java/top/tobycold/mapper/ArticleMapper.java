package top.tobycold.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.tobycold.annotation.AutoSetTime;
import top.tobycold.pojo.ArticleEntity;

@Mapper
public interface ArticleMapper {

    /**
     * 存储文章
     * @param articleEntity
     */
    @AutoSetTime
    void save(ArticleEntity articleEntity);

    void delete(Integer id);
}
