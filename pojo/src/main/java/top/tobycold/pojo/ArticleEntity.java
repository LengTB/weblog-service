package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "文章实体")
public class ArticleEntity {
    @Schema(name = "标题")
    public String title;
    @Schema(name = "标签")
    public String tags;
    @Schema(name = "路由名字")
    public String routeName;
    @Schema(name = "正文")
    public String body;
    @Schema(name = "创建时间")
    public LocalDateTime creatTime;
    @Schema(name = "创建用户")
    public String createUser;
    @Schema(name = "修改用户")
    public String updateUser;
    @Schema(name = "修改时间")
    public LocalDateTime updateTime;
    @Schema(name = "发布ip")
    public String ip;
    @Schema(name = "观看人数")
    public Integer seeCount;
    @Schema(name = "点赞人数")
    public Integer loveCount;
}
