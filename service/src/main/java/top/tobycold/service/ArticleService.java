package top.tobycold.service;

import top.tobycold.dto.ArticleDTO;
import top.tobycold.pojo.ArticleEntity;

public interface ArticleService {

    /**
     * 保存文章
     * @param articleDTO
     */
    void save(ArticleDTO articleDTO);

    /**
     * 根据 路由名称 查询文章
     * @param path
     * @return
     */

    ArticleEntity selectByPath(String path);
}
