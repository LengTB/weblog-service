package top.tobycold.util;

public enum QuestionType {


    SINGLE("单选题"),
    MULTIPLE("多选题"),
    JUDGEMENT("判断题"),
    COMPLETION("填空题");

    private String name;


    QuestionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
