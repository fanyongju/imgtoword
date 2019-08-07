package com.fyj.imgtoword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author fanyongju
 * @Title: IndexController
 * @Description: TODO
 * @date 2018/9/1415:14
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "imgtoword/index";
    }
}
