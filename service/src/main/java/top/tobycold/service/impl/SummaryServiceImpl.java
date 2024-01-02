package top.tobycold.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.dto.ArticleDTO;
import top.tobycold.mapper.SummaryMapper;
import top.tobycold.pojo.SummaryEntity;
import top.tobycold.service.SummaryService;

import java.util.List;

@Service
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    SummaryMapper summaryMapper;
    /**
     * 添加 摘要
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
     * 修改 摘要
     * @param articleDTO
     */
    public void update(ArticleDTO articleDTO){

    }

    /**
     * 删除 摘要
     * @param articleDTO
     */
    public void delete(ArticleDTO articleDTO){

    }
    /**
     * 分页查询 摘要
     */
    public List<SummaryEntity> selectByPages(int page){
        int total = 10;
        return summaryMapper.selectByPages(page * total, total);
    }
    /**
     * 查询总数
     * @return
     */
    public Long getTotal(){
        return summaryMapper.getTotal();
    }

}
