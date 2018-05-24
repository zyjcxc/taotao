package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mengqa
 * @create 2018-05-23 17:24
 **/
@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/{page}")
    public String getItemById(@PathVariable("page") String page) {
        return page;
    }

}
