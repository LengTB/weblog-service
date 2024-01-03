package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


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
    private String summary;
    @Schema(name = "状态")
    private Integer status;
    @Schema(name = "创建时间")
    private LocalDateTime createTime;
    @Schema(name = "创建用户")
    private String createUser;
    @Schema(name = "修改用户")
    private String updateUser;
    @Schema(name = "修改时间")
    private LocalDateTime updateTime;
    @Schema(name = "观看人数")
    private Integer seeCount;
    @Schema(name = "点赞人数")
    private Integer loveCount;
}
