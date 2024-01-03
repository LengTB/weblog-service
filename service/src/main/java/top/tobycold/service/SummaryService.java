package top.tobycold.service;

import top.tobycold.dto.ArticleDTO;
import top.tobycold.pojo.SummaryEntity;

import java.util.List;

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
    List<SummaryEntity> selectByPages(Integer status, int page);

    /**
     * 查询总数
     * @return
     */
    Long getTotal(Integer status);
}
