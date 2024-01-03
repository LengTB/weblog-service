package top.tobycold.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(name = "用户信息")
public class UserDTO implements Serializable {


    @Schema(name = "账号")
    private String account;

    @Schema(name = "密码")
    private String password;

    @Schema(name = "名字")
    private String username;

    @Schema(name = "性别")
    private String sex;

    @Schema(name = "邮箱")
    private String email;

    @Schema(name = "IP地址")
    private String ip;

    @Schema(name = "号码")
    private String phone;
}
