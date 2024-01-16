package top.tobycold.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import top.tobycold.annotation.AutoSetTime;
import top.tobycold.util.AutoTimeType;
import top.tobycold.util.BaseContext;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class SetTheTime {
    @Pointcut("execution(* top.tobycold.mapper.*.*(..)) && @annotation(top.tobycold.annotation.AutoSetTime)")
    public void targetApproach() {
    }

    @Before("targetApproach()")
    public void setDate(JoinPoint joinPoint) {
        log.info("开启aop自动注入");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        AutoSetTime annotation = signature.getMethod().getAnnotation(AutoSetTime.class);
        AutoTimeType mode = annotation.mode();
        Object[] args = joinPoint.getArgs();
        Object arg = args[0];
        if (arg == null)
            return;

        try {
            String name = BaseContext.getName();
            LocalDateTime now = LocalDateTime.now();
            if (mode == AutoTimeType.CREATE) {
                Method setCreateTime = arg.getClass().getMethod("setCreateTime", LocalDateTime.class);
                Method setCreateUser = arg.getClass().getMethod("setCreateUser", String.class);
                Method setUpdateTime = arg.getClass().getMethod("setUpdateTime", LocalDateTime.class);
                Method setUpdateUser = arg.getClass().getMethod("setUpdateUser", String.class);

                setCreateTime.invoke(arg, now);
                setCreateUser.invoke(arg, name);
                setUpdateTime.invoke(arg, now);
                setUpdateUser.invoke(arg, name);
            }else if(mode == AutoTimeType.UPDATE){
                Method setUpdateTime = arg.getClass().getMethod("setUpdateTime", LocalDateTime.class);
                Method setUpdateUser = arg.getClass().getMethod("setUpdateUser", String.class);
                setUpdateTime.invoke(arg, now);
                setUpdateUser.invoke(arg, name);
            }else {
                log.error("AutoTimeType中没这个模式");
            }

        } catch (Exception e) {
            log.error("AutoSetTime Error! on top.tobycold.aop.SetTheTime class");
        }

    }
}
