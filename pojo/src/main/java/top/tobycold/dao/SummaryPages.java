package top.tobycold.dao;

import lombok.Builder;
import lombok.Data;
import top.tobycold.pojo.SummaryEntity;

import java.util.List;

@Data
@Builder
public class SummaryPages {
    List<SummaryEntity> bodys;

    Integer total;
}
