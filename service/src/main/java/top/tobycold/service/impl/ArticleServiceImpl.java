package top.tobycold.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.dto.ArticleDTO;
import top.tobycold.mapper.ArticleMapper;
import top.tobycold.pojo.ArticleEntity;
import top.tobycold.service.ArticleService;
import top.tobycold.service.SummaryService;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    /**
     * 保存文章
     ** 这里做一个说明，按理来说，articleId 应该跟主键id是一样的，因为summary表是依附于article表存在的，他们之间的数据是一一对应的！
     * @param articleDTO
     ** ArticleEntity        ArticleDTO
     *
     * id                    title
     * title                 summary
     * tags                  tags
     * routerName            routerName
     * body                  creatTime
     * creatTime             body
     * createUser
     * updateUser
     * updateTime
     * ip
     * loveCount
     * seeCount
     */
    public void save(ArticleDTO articleDTO) {
        ArticleEntity article = ArticleEntity.builder()
                .ip(articleDTO.getIp())
                .loveCount(0)
                .seeCount(0)
                .build();
        BeanUtils.copyProperties(articleDTO, article);
        articleMapper.save(article);
    }
}
