package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;

/**
 * @author mengqa
 * @create 2018-05-23 16:58
 **/
public interface ItemService {

    TbItem getItemById(Long id);

    EasyUIDataGridResult getItemList(int page, int rows);

    TaotaoResult saveItem(TbItem item, TbItemDesc itemDesc);
}
