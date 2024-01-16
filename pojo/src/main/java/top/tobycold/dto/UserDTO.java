package top.tobycold.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserDTO {
    @Schema(name = "名称")
    private String name;
    @Schema(name = "性别")
    private String sex;
    @Schema(name = "邮箱")
    private String email;
    @Schema(name = "号码")
    private String phone;
    @Schema(name = "github")
    private String github;
    @Schema(name = "qq")
    private String qq;
}
