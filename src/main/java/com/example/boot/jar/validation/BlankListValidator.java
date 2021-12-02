package com.example.boot.jar.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;

public class BlankListValidator implements ConstraintValidator<BlankList, String> {

    @Override
    public void initialize(BlankList constraintAnnotation) {
        //在启动时执行
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //模拟数据库
        ArrayList<String> list = new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
        }};
        return !list.contains(s);
    }

}
