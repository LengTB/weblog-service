package top.tobycold.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.tobycold.pojo.ArticleEntity;

@Mapper
public interface ArticleMapper {

    /**
     * 存储文章
     * @param articleEntity
     */
    void save(ArticleEntity articleEntity);

    /**
     * 根据id删除文章
     * @param id
     */
    @Delete("delete from articles where id = #{id}")
    void delete(Long id);

    /**
     * 根据路由名称查询文章
     * @param routerName
     * @return
     */
    @Select("select * from articles where routerName = #{routerName}")
    ArticleEntity select(String routerName);
}
