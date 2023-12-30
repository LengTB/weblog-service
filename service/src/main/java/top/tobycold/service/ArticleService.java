package top.tobycold.service;

import top.tobycold.dto.ContextDTO;

public interface ArticleService {

    /**
     * 保存文章
     * @param contextDTO
     */
    void save(ContextDTO contextDTO);
}
