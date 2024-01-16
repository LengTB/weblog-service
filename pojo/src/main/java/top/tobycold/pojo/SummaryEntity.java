package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
@Schema(name = "摘要实体")
public class SummaryEntity {
    @Schema(name = "摘要id")
    private Long id;
    @Schema(name = "标题")
    private String title;
    @Schema(name = "路径名称")
    private String path;
    @Schema(name = "内容")
    private String body;
    //状态
    @Schema(name = "状态")
    private Integer status;
    //文章详细id
    @Schema(name = "文章id")
    private String articleDetailId;
}
