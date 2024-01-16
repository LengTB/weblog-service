package top.tobycold.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDTO {
    @Schema(name = "标题")
    private String title;
    @Schema(name = "路径")
    private String path;
    @Schema(name = "状态")
    private String status;
    @Schema(name = "内容")
    private String body;
    @Schema(name = "ip")
    private String ip;
}
