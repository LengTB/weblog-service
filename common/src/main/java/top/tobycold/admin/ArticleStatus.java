package top.tobycold.admin;

public enum ArticleStatus {
    //隐藏
    INVISIBLE(0),
    //可见
    VISIBLE(1),
    //未发布
    UNPUBLISHED(2),
    //所有
    ALL(null);

    private Integer status;

    ArticleStatus(Integer status) {
        this.status = status;
    }

    public Integer STATUS() {
        return status;
    }
}
