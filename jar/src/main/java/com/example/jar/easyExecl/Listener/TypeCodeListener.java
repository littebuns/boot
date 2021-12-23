package com.example.jar.easyExecl.Listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class TypeCodeListener extends AnalysisEventListener {

    private final List<Object> datas = new ArrayList<>();

    @Override
    public void invoke(Object data, AnalysisContext context) {
        System.out.println(data.toString());
        datas.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

}
