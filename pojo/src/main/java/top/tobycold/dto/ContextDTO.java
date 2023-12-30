package top.tobycold.dto;

import lombok.Data;

@Data
public class ContextDTO {

    public String title;
    public String summary;
    public String tags;
    public String routeName;
    public String publishTime;
    public String body;
}
