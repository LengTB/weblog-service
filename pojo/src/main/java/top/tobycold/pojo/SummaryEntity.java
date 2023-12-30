package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@Schema(name = "摘要实体")
public class SummaryEntity {
    @Schema(name = "标题")
    String title;
    @Schema(name = "摘要")
    String body;
    @Schema(name = "时间")
    String date;
    @Schema(name = "观看人数")
    Integer looking;
    @Schema(name = "点赞人数")
    Integer love;
    @Schema(name = "文章id")
    String contextId;
}
