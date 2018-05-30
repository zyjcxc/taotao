package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * @author mengqa
 * @create 2018-05-30 9:40
 **/
public interface ItemParamService {

    TaotaoResult findByCatId(Long itemCatId);

    TaotaoResult save(TbItemParam itemParam);

    EasyUIDataGridResult getItemParamList(Integer page, Integer rows);
}
