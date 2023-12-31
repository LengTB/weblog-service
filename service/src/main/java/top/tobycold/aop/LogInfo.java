package top.tobycold.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogInfo {

    @Pointcut("execution(* top.tobycold.controller.*.*.*(..))")
    private void log(){}

    @Before("log()")
    public void consoleLog(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
//        log.info("{}方法：日志记录：{}",joinPoint.getSignature().getName(), args);
    }
}
