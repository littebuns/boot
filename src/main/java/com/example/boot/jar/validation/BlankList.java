package com.example.boot.jar.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//限定使用范围-只能在字段上使用
@Target({ElementType.FIELD})
//生命周期 可以在代码运行的时候通过反射获取到注解
@Retention(RetentionPolicy.RUNTIME)
//指定该注解的校验逻辑
@Constraint(validatedBy = BlankListValidator.class)
public @interface BlankList {

    String message() default "该港口位于黑名单中";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
