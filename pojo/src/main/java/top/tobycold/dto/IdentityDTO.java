package top.tobycold.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdentityDTO {
    @Schema(name = "账号")
    private String account;
    @Schema(name = "密码")
    private String password;
    @Schema(name = "验证码")
    private String code;
}
