package top.tobycold.util;

public class BaseContext {
    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String getName(){
        return threadLocal.get();
    }

    public static void setName(String name){
        threadLocal.set(name);
    }
}
