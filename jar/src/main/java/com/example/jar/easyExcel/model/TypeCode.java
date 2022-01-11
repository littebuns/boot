package com.example.jar.easyExcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("typeCode")
public class TypeCode {

    @ExcelProperty(value = "平台系统代码", index = 0)
    private String code;
    @ExcelProperty(value = "平台系统名称", index = 1)
    private String name;

    @ExcelProperty(value = "通道系统代码", index = 2)
    private String channelCode;
    @ExcelProperty(value = "通道系统名称", index = 3)
    private String channelName;
}
