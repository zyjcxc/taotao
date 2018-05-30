package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author mengqa
 * @create 2018-05-23 17:01
 **/
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/query/itemcatid/{catId}")
    @ResponseBody
    public TaotaoResult findByCatId(@PathVariable(value = "catId") Long catId) {
        return itemParamService.findByCatId(catId);
    }

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult list(@RequestParam Integer page, @RequestParam Integer rows) {

        EasyUIDataGridResult list = itemParamService.getItemParamList(page, rows);

        return list;
    }

    @RequestMapping(value = "/save/{catId}", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult save(@PathVariable(value = "catId") Long catId, TbItemParam itemParam) {
        itemParam.setItemCatId(catId);
        return itemParamService.save(itemParam);
    }





}
