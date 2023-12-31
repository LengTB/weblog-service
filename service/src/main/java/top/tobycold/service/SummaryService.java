package top.tobycold.service;

import top.tobycold.dto.ArticleDTO;

public interface SummaryService {

    /**
     * 添加摘要
     * @param articleDTO
     */
    void save(ArticleDTO articleDTO);

    /**
     * 修改摘要
     * @param articleDTO
     */
    void update(ArticleDTO articleDTO);

    /**
     * 删除摘要
     * @param articleDTO
     */
    void delete(ArticleDTO articleDTO);
    /**
     * 分页查询摘要
     */
}
