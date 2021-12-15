package com.example.qlexpress.contoller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.qlexpress.entity.Result;
import com.example.qlexpress.entity.Rule;
import com.example.qlexpress.mapper.RuleMapper;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class RuleController {

    @Autowired
    private RuleMapper ruleMapper;

    @GetMapping("/rule")
    public Result rule(@RequestParam(value = "field") String field,
                       @RequestParam(value = "content") String content) throws Exception {
        //根据字段名找到规则文件
            QueryWrapper<Rule> eq = new QueryWrapper<Rule>().eq("field", field);
        Rule rule = ruleMapper.selectOne(eq);
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("content", content);
        Object r = runner.execute(rule.getExpress(), context, null, true, false);
        if (null == r){
            return new Result(true,"成功");
        }else{
            return new Result(false, r.toString());
        }
    }



}
