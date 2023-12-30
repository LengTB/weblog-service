package top.tobycold.exception;

public class JwtException extends RuntimeException{
    public JwtException(String message) {
        super(message);
    }
}
