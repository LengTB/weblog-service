package top.tobycold.dao;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "个人名片")
public class Card {
    @Schema(name = "头像")
    String avatar;
    @Schema(name = "名称")
    String name;
    @Schema(name = "个签")
    String signature;
    @Schema(name = "等级")
    Integer grade;
    @Schema(name = "是否为管理员")
    Boolean isAdmin;
    @Schema(name = "评论数")
    Integer commentCount;
    @Schema(name = "点赞数")
    Integer likeCount;
    @Schema(name = "标签数")
    Integer tagCount;
    @Schema(name = "GitHub")
    String github;
    @Schema(name = "qq")
    String qq;
    @Schema(name = "bilibili")
    String bilibili;
}
