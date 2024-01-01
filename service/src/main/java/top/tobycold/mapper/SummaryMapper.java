package top.tobycold.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.tobycold.pojo.SummaryEntity;

import java.util.List;

@Mapper
public interface SummaryMapper {
    void save(SummaryEntity summaryEntity);

    List<SummaryEntity> selectByPages(int page, int total);
}
