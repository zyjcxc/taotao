package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mengqa
 * @create 2018-05-23 17:01
 **/
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable("itemId") Long itemId) {
        return itemService.getItemById(itemId);
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult list(@RequestParam Integer page, @RequestParam Integer rows) {

        EasyUIDataGridResult itemList = itemService.getItemList(page, rows);

        return itemList;
    }



}
