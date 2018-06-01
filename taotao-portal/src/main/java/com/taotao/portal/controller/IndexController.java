package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mengqa
 * @create 2018-05-23 17:24
 **/
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String showIndex() {
        return "index";
    }


}
