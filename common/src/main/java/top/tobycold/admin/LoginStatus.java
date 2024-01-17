package top.tobycold.admin;

public enum LoginStatus {
    SUCCESS(0),
    ERROR(1);
    private Integer status;
    LoginStatus(Integer status) {
        this.status = status;
    }
    public Integer getStatus() {
        return status;
    }
}
