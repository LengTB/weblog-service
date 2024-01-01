package top.tobycold.service;

import top.tobycold.dto.ArticleDTO;
import top.tobycold.pojo.ArticleEntity;

public interface ArticleService {

    /**
     * 保存文章
     * @param articleDTO
     */
    void save(ArticleDTO articleDTO);
}
