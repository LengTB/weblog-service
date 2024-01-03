package top.tobycold.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.dto.ArticleDTO;
import top.tobycold.mapper.ArticleMapper;
import top.tobycold.pojo.ArticleEntity;
import top.tobycold.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    /**
     * 保存文章
     *
     * @param articleDTO
     * @return
     */
    public void save(ArticleDTO articleDTO) {
        ArticleEntity article = ArticleEntity.builder()
                .build();
        BeanUtils.copyProperties(articleDTO, article);
        articleMapper.save(article);
    }

    /**
     * 根据 路由名称 查询文章
     *
     * @param routerName
     * @return
     */
    public ArticleEntity selectByRouterName(String routerName) {
        return articleMapper.select(routerName);
    }
}
