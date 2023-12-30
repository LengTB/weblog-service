package top.tobycold.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Result<T> success() {
        Result<T> seccess = new Result<T>();
        seccess.code = 1;
       return seccess;
    }
    public static <T> Result<T> success(String message) {
        return new Result<T>(1, message, null);
    }
    public static <T> Result<T> success(String message, T t) {
        return new Result<T>(1, message,t);
    }

    public static <T> Result<T> error(T t) {
        return new Result<>(0, null, t);
    }
    public static <T> Result<T> error(String mes, T t) {
        return new Result<T>(0, mes,t);
    }
}
