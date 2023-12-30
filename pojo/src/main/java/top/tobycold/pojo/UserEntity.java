package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "用户实体")
public class UserEntity {
    @Schema(name = "自增id")
    private Long id;
    @Schema(name = "名字")
    private String username;
    @Schema(name = "性别")
    private String sex;
    @Schema(name = "密码")
    private String password;
    @Schema(name = "邮箱")
    private String email;
    @Schema(name = "IP地址")
    private String ip;
    @Schema(name = "号码")
    private String phone;

}
