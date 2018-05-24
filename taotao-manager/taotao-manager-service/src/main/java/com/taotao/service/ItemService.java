package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;

/**
 * @author mengqa
 * @create 2018-05-23 16:58
 **/
public interface ItemService {

    TbItem getItemById(Long id);

    EasyUIDataGridResult getItemList(int page, int rows);
}
