package com.example.jar.easyExcel.Listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.jar.easyExcel.service.TypeCodeService;
import com.example.jar.easyExcel.mapper.TypeCodeMapper;
import com.example.jar.easyExcel.model.TypeCode;

import java.util.ArrayList;
import java.util.List;

public class TypeCodeListener extends AnalysisEventListener<TypeCode> {

    private final List<TypeCode> typeCodes = new ArrayList<>();
    private static final int BATCH_COUNT = 1000;

    private TypeCodeMapper typeCodeMapper;
    private TypeCodeService typeCodeService;

    public TypeCodeListener(TypeCodeService typeCodeService){
        this.typeCodeService = typeCodeService;
    }

    @Override
    public void invoke(TypeCode data, AnalysisContext context) {
        typeCodes.add(data);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        boolean b = typeCodeService.saveBatch(typeCodes);
        System.out.println(b);
    }

}
