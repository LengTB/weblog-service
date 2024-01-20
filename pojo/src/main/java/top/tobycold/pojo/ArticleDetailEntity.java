package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "文章详情实体")
public class ArticleDetailEntity {
    @Schema(name = "创建时间")
    private String createTime;
    @Schema(name = "创建用户")
    private String createUser;
    @Schema(name = "修改时间")
    private String updateTime;
    @Schema(name = "修改用户")
    private String updateUser;
    @Schema(name = "点赞人数")
    private Integer linkCount;
    @Schema(name = "预览人数")
    private Integer seeCount;
    @Schema(name = "IP地址")
    private String ip;
}
