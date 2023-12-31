package top.tobycold.dto;

import lombok.Data;

@Data
public class ArticleDTO {

    private String title;
    private String summary;
    private String tags;
    private String routerName;
    private String creatTime;
    private String body;
    private String ip;
}
