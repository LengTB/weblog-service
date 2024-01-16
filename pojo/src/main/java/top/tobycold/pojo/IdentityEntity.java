package top.tobycold.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
public class IdentityEntity {
    @Schema(name = "自增id")
    private Long id;
    @Schema(name = "名称")
    private String name;
    @Schema(name = "账号")
    private String account;
    @Schema(name = "密码")
    private String password;
}
