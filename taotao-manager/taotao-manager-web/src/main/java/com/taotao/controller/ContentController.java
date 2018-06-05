package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mengqa
 * @create 2018-06-05 10:12
 **/
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;


    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUIDataGridResult list(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Long categoryId) {
        EasyUIDataGridResult itemList = contentService.getContentList(page, rows, categoryId);
        return itemList;
    }

    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult save(TbContent content) {
        return contentService.save(content);
    }


}
