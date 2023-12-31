package top.tobycold.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.tobycold.pojo.SummaryEntity;

@Mapper
public interface SummaryMapper {
    void save(SummaryEntity summaryEntity);
}
