package top.tobycold.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.tobycold.annotation.AutoSetTime;
import top.tobycold.pojo.SummaryEntity;

import java.util.List;

@Mapper
public interface SummaryMapper {

    @AutoSetTime
    void save(SummaryEntity summaryEntity);

    List<SummaryEntity> selectByPages(int page, int total);

    @Select("select count(*) from summarys")
    Long getTotal();
}
