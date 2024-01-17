package top.tobycold.admin;

public enum IdentityName {
    USER("用户"),
    ADMIN("管理员"),
    OTHER("其他");

    private String name;
    IdentityName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
