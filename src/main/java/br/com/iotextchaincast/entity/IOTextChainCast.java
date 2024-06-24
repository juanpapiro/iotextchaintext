package br.com.iotextchaincast.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IOTextChainCast {

    int length();
    int order() default 0;
    String align() default "L";
    String trelling() default " ";
    String pattern() default "";
    String decimalSeparator() default "";
    int decimalPrecision() default 2;
    int decimalMovePoint() default 0;

}
