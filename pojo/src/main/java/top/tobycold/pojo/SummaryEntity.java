package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@Schema(name = "摘要实体")
public class SummaryEntity {
    @Schema(name = "主键自增id")
    private Long id;
    @Schema(name = "标题")
    private String title;
    @Schema(name = "路由名称")
    private String routerName;
    @Schema(name = "摘要")
    private String body;
}
