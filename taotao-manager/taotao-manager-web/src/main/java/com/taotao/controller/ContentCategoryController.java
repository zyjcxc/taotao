package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContentCategory;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author mengqa
 * @create 2018-06-05 10:12
 **/
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> list(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        return contentCategoryService.getCategoryList(parentId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult create(TbContentCategory contentCategory) {
        return contentCategoryService.save(contentCategory);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult delete(TbContentCategory contentCategory) {
        return contentCategoryService.delete(contentCategory);
    }

}
