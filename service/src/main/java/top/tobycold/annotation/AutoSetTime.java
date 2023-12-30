package top.tobycold.annotation;

import top.tobycold.util.AutoTimeType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface AutoSetTime {
    AutoTimeType mode() default AutoTimeType.CREATE;
}
