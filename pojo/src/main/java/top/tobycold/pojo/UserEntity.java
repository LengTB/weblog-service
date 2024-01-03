package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "用户实体")
public class UserEntity {
    @Schema(name = "主键自增id")
    private Long id;
    @Schema(name = "账号")
    private String account;
    @Schema(name = "密码")
    private String password;
    @Schema(name = "名称")
    private String name;
    @Schema(name = "个签")
    private String signature;
    @Schema(name = "等级")
    private String grade;
    @Schema(name = "是否为管理员")
    private String isAdmin;
    @Schema(name = "评论数")
    private String commentCount;
    @Schema(name = "点赞数")
    private String likeCount;
    @Schema(name = "标签数")
    private String tagCount;
    @Schema(name = "github")
    private String github;
    @Schema(name = "qq")
    private String qq;
    @Schema(name = "bilibili")
    private String bilibili;
    @Schema(name = "头像")
    private String avatar;

}
