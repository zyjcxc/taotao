package com.taotao.rest.controller;

import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author mengqa
 * @create 2018-06-01 14:49
 **/
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

   /* @RequestMapping(value = "/itemcat/list", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String getItemCatList(String callback) {

        CatResult itemCatList = itemCatService.getItemCatList();
        String json = JsonUtils.objectToJson(itemCatList);
        String result = callback + "(" + json + ")";
        return result;
    }*/

    @RequestMapping(value = "/itemcat/list")
    @ResponseBody
    public Object getItemCatList(String callback) {
        CatResult itemCatList = itemCatService.getItemCatList();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(itemCatList);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
