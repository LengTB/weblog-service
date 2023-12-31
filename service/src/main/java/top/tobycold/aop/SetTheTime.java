package top.tobycold.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import top.tobycold.annotation.AutoSetTime;
import top.tobycold.util.AutoTimeType;
import top.tobycold.util.BaseContext;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Slf4j
public class SetTheTime {
    @Pointcut("execution(* top.tobycold.mapper.*.*(..)) && @annotation(top.tobycold.annotation.AutoSetTime)")
    public void targetApproach() {
    }

    @Before("targetApproach()")
    public void setDate(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        AutoSetTime annotation = signature.getMethod().getAnnotation(AutoSetTime.class);
        AutoTimeType mode = annotation.mode();
        Object arg = joinPoint.getArgs()[0];
        if (arg == null)
            return;

        try {
            String id = BaseContext.getId();
            if (mode == AutoTimeType.CREATE) {
                Method setCreateTime = arg.getClass().getMethod("setCreateTime", String.class);
                Method setCreateUser = arg.getClass().getMethod("setCreateUser", String.class);
                Method setUpdateTime = arg.getClass().getMethod("setUpdateTime", String.class);
                Method setUpdateUser = arg.getClass().getMethod("setUpdateUser", String.class);

                setCreateTime.invoke(arg, LocalDateTime.now());
                setCreateUser.invoke(arg, id);
                setUpdateTime.invoke(arg, LocalDateTime.now());
                setUpdateUser.invoke(arg, id);
            }else if(mode == AutoTimeType.UPDATE){
                Method setUpdateTime = arg.getClass().getMethod("setUpdateTime", String.class);
                Method setUpdateUser = arg.getClass().getMethod("setUpdateUser", String.class);
                setUpdateTime.invoke(arg, LocalDateTime.now());
                setUpdateUser.invoke(arg, id);
            }else {
                log.error("AutoTimeType中没这个模式");
            }

        } catch (Exception e) {
            log.error("AutoSetTime Error! on top.tobycold.aop.SetTheTime class");
        }

    }
}
