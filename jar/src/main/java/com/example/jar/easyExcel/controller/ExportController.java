package com.example.jar.easyExcel.controller;

import com.alibaba.excel.EasyExcel;
import com.example.jar.easyExcel.Listener.TypeCodeListener;
import com.example.jar.easyExcel.service.TypeCodeService;
import com.example.jar.easyExcel.model.TypeCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class ExportController {

    @Autowired
    private TypeCodeService typeCodeService;

    @PostMapping("/export")
    public String exportUser(@RequestParam("file") MultipartFile file) {
//        EasyExcel.read(file.getInputStream(), TypeCode.class, new PageReadListener<TypeCode>(dataList -> {
//            for (TypeCode typeCode : dataList) {
//                log.info(typeCode.toString());
//            }
//        })).sheet().doRead();
//        EasyExcel.read(file.getInputStream(), new TypeCodeListener());
//        return file.getName();
        try {
            TypeCodeListener codeListener = new TypeCodeListener(typeCodeService);
            EasyExcel.read(file.getInputStream(), TypeCode.class, codeListener).sheet().doRead();
        }catch (Exception e){
            return e.getMessage();
        }
        return "success";
    }

}
