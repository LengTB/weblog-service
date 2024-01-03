package top.tobycold.admin;

public enum ArticleStatus {
    INVISIBLE(0),
    VISIBLE(1),
    UNPUBLISHED(2),
    ALL(null);

    private Integer status;

    ArticleStatus(Integer status) {
        this.status = status;
    }

    public Integer STATUS() {
        return status;
    }
}
