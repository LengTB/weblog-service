package top.tobycold.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.tobycold.annotation.AutoSetTime;
import top.tobycold.pojo.SummaryEntity;

import java.util.List;

@Mapper
public interface SummaryMapper {

    @AutoSetTime
    void save(SummaryEntity summaryEntity);

    List<SummaryEntity> selectByPages(Integer status, Integer start, Integer total);

    Long getTotal(Integer status);
}
