package top.tobycold.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.dto.ArticleDTO;
import top.tobycold.mapper.SummaryMapper;
import top.tobycold.pojo.SummaryEntity;
import top.tobycold.service.SummaryService;

@Service
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    SummaryMapper summaryMapper;
    /**
     * 添加摘要
     * @param articleDTO
     */
    public void save(ArticleDTO articleDTO){

        SummaryEntity summary = SummaryEntity.builder()
                .title(articleDTO.getTitle())
                .body(articleDTO.getSummary())
                .routerName(articleDTO.getRouterName())
                .build();
        summaryMapper.save(summary);
    }

    /**
     * 修改摘要
     * @param articleDTO
     */
    public void update(ArticleDTO articleDTO){

    }

    /**
     * 删除摘要
     * @param articleDTO
     */
    public void delete(ArticleDTO articleDTO){

    }
    /**
     * 分页查询摘要
     */
}
