package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

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
    @Schema(name = "创建时间")
    private LocalDateTime createTime;
    @Schema(name = "创建用户")
    private String createUser;
    @Schema(name = "修改用户")
    private String updateUser;
    @Schema(name = "修改时间")
    private LocalDateTime updateTime;
    @Schema(name = "发布ip")
    private String ip;
    @Schema(name = "观看人数")
    private Integer seeCount;
    @Schema(name = "点赞人数")
    private Integer loveCount;
}
