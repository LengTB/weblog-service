package top.tobycold.util;

public class BaseContext {
    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String getId(){
        return threadLocal.get();
    }

    public static void setId(String id){
        threadLocal.set(id);
    }
}
