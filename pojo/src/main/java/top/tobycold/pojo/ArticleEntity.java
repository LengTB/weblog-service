package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Schema(name = "文章实体")
public class ArticleEntity {

    @Schema(name = "文章自增id")
    private Long id;
    @Schema(name = "路径")
    private String path;
    @Schema(name = "文章正文")
    private String body;
    @Schema(name = "IP地址")
    private String ip;
    @Schema(name = "点赞数")
    private String likeCount;
    @Schema(name = "预览数")
    private String seeCount;
    @Schema(name = "创建人")
    private String createUser;
    @Schema(name = "创建时间")
    private String createTime;
    @Schema(name = "修改用户")
    private String updateUser;
    @Schema(name = "修改时间")
    private String updateTime;
}
