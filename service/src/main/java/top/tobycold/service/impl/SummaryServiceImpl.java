package top.tobycold.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.admin.ArticleStatus;
import top.tobycold.dto.ArticleDTO;
import top.tobycold.mapper.SummaryMapper;
import top.tobycold.pojo.SummaryEntity;
import top.tobycold.service.SummaryService;

import java.util.List;

@Service
@Slf4j
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    SummaryMapper summaryMapper;

    /**
     * 添加 摘要
     *
     * @param articleDTO
     */
    public void save(ArticleDTO articleDTO) {

    }

    /**
     * 修改 摘要
     *
     * @param articleDTO
     */
    public void update(ArticleDTO articleDTO) {

    }

    /**
     * 删除 摘要
     *
     * @param articleDTO
     */
    public void delete(ArticleDTO articleDTO) {

    }

    /**
     * 分页查询 摘要
     */
    public List<SummaryEntity> selectByPages(Integer status, int page) {
        int total = 10;
        int pages = page * total;
        return summaryMapper.selectByPages(status, pages, total);
    }
}
