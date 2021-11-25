package com.example.boot.jar.validation;

import com.example.boot.common.Result;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CatController {

    @PostMapping("/cat")
    public Result cat(@Validated @RequestBody Cat cat, BindingResult bindingResult){
        ArrayList<String> list = new ArrayList<>();
        if (bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                list.add(fieldError.getField() + "字段出错: " + fieldError.getDefaultMessage());
            }
            return Result.error(list);
        }else {
            return Result.success(cat);
        }
    }

}
