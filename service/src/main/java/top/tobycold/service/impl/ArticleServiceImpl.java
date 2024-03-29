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
        ArticleEntity article = new ArticleEntity();
        BeanUtils.copyProperties(articleDTO, article);
        articleMapper.save(article);
    }
    /**
     * 根据 路由名称 查询文章
     *
     * @param path
     * @return
     */
    public ArticleEntity selectByPath(String path) {
        return articleMapper.select(path);
    }
}
