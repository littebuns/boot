package com.example.qlexpress.runner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.qlexpress.entity.Rule;
import com.example.qlexpress.mapper.RuleMapper;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@SpringBootTest
public class ExpressRunnerDemon {

    @Autowired
    private RuleMapper ruleMapper;

    @Test
    public void t1() throws Exception {
        String content = "CLCD";
        String str = "CLCLD,PHCDB,USHNT,BRIGI,USLLB,USDYG,BRIGI,BRSEP,USHS7,USPOF";
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (content.contains(s)){
                System.out.println("xxb");
            }
        }


        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("content","CLCLD1");

        String express = "str = \"CLCLD,PHCDB,USHNT,BRIGI,USLLB,USDYG,BRIGI,BRSEP,USHS7,USPOF\";\n" +
                "split = str.split(\",\");\n" +
                "  for (i=0;i<split.length;i++) {\n" +
                "  key = split[i];\n" +
                "   System.out.println(key);\n" +
                "  }";
        Object r = runner.execute(express, context, null, true, false );
        System.out.println(r);

    }

    @Test
    public void t2(){
        QueryWrapper<Rule> eq = new QueryWrapper<Rule>().eq("field", "name");
        Rule rule = ruleMapper.selectOne(eq);
        System.out.println(rule);
    }


}
