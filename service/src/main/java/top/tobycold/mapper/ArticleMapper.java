package top.tobycold.mapper;

import org.apache.ibatis.annotations.Delete;
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

    /**
     * 根据id删除文章
     * @param id
     */
    @Delete("delete from articles where id = #{id}")
    void delete(Long id);
}
