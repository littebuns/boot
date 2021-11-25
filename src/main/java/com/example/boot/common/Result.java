package com.example.boot.common;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private int code;
    private String message;
    private Object data;



    public static Result success(Object... obj){
        return new Result(200, "操作成功", obj);
    }

    public static Result error(Object... obj){
        return new Result(500, "操作失败", obj);
    }

}
