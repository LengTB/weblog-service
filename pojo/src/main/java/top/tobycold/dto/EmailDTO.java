package top.tobycold.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EmailDTO {
    @Schema(name = "邮箱")
    private String email;
}
