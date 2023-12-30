package top.tobycold.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class MainException {
    @ExceptionHandler(Exception.class)

    public void handleException(Exception e) {

        e.printStackTrace();
        log.error("拦截所有");
    }
}
