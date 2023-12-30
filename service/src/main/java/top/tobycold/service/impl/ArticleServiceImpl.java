package top.tobycold.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.dto.ContextDTO;
import top.tobycold.mapper.ArticleMapper;
import top.tobycold.pojo.ArticleEntity;
import top.tobycold.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    /**
     * 保存文章
     * @param contextDTO
     */
    public void save(ContextDTO contextDTO) {
        ArticleEntity articleEntity = new ArticleEntity();
        BeanUtils.copyProperties(contextDTO, articleEntity);
        articleMapper.save(articleEntity);
    }
}
