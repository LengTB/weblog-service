package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "文章实体")
public class ArticleEntity {
    @Schema(name = "主键自增id")
    private Long id;
    @Schema(name = "标题")
    private String title;
    @Schema(name = "标签")
    private String tags;
    @Schema(name = "路由名字")
    private String routerName;
    @Schema(name = "正文")
    private String body;
    @Schema(name = "发布ip")
    private String ip;
}
