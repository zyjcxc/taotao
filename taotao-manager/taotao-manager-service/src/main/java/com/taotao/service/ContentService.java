package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * @author mengqa
 * @create 2018-06-05 10:08
 **/
public interface ContentService {

    EasyUIDataGridResult getContentList(int page, int rows, Long categoryId);

    TaotaoResult save(TbContent content);
}
