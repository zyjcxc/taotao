package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContentCategory;

import java.util.List;

/**
 * @author mengqa
 * @create 2018-06-05 10:08
 **/
public interface ContentCategoryService {

    List<EasyUITreeNode> getCategoryList(long parentId);

    TaotaoResult save(TbContentCategory contentCategory);

    TaotaoResult delete(TbContentCategory contentCategory);
}
