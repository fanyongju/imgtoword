package com.fyj.qps.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fanyongju
 * @Title: QpsController
 * @date 2019/1/9 16:50
 */
@Controller
@RequestMapping("/qps/")
public class QpsController {
    @RequestMapping("")
    public String input(){
        return "qps/input";
    }

    @PostMapping("lineChart")
    public ModelAndView lineChart(String message){
        System.out.println(message);
        String[] lines = StringUtils.split(message,"\n");
        List<String> keyList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();
        for(String line : lines){
            String cleanLine = StringUtils.trim(line);
            String[] keyAndValue = StringUtils.split(cleanLine," ");
            keyList.add(keyAndValue[1]);
            valueList.add(Integer.parseInt(keyAndValue[0]));
        }
        ModelAndView model = new ModelAndView();
        model.addObject("keys",keyList);
        model.addObject("values",valueList);
        model.setViewName("qps/lineChart");
        return model;
    }
}
