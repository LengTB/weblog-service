package top.tobycold.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Card {
    String name;
    String signature;
    Integer grade;
    Boolean admin;
}
