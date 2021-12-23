package com.example.jar.easyExecl.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.example.jar.easyExecl.Listener.TypeCodeListener;
import com.example.jar.easyExecl.model.TypeCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class ExportController {

    @PostMapping("/export")
    public String exportUser(@RequestParam("file") MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), TypeCode.class, new PageReadListener<TypeCode>(dataList -> {
            for (TypeCode typeCode : dataList) {
                log.info(typeCode.toString());
            }
        })).sheet().doRead();
        EasyExcel.read(file.getInputStream(), new TypeCodeListener());
        return file.getName();
    }

}
