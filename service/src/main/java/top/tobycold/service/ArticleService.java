package top.tobycold.service;

import top.tobycold.dto.ArticleDTO;

public interface ArticleService {

    /**
     * 保存文章
     * @param articleDTO
     */
    void save(ArticleDTO articleDTO);
}
