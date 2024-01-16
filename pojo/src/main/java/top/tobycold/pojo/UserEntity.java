package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "用户实体")
public class UserEntity {
    @Schema(name = "用户自增id")
    private Long id;
    @Schema(name = "名称")
    private String name;
    @Schema(name = "身份")
    private String identity;
    @Schema(name = "等级")
    private String grade;
    @Schema(name = "邮箱")
    private String email;
    @Schema(name = "电话")
    private String phone;
    @Schema(name = "github")
    private String github;
    @Schema(name = "qq")
    private String qq;
    @Schema(name = "B站")
    private String bilibili;
    @Schema(name = "头像")
    private String avatar;
}
