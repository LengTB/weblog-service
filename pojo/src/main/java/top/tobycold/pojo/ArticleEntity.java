package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "文章实体")
public class ArticleEntity {

    @Schema(name = "文章自增id")
    private Long id;
    @Schema(name = "路径")
    private String path;
    @Schema(name = "正文")
    private String body;
}
