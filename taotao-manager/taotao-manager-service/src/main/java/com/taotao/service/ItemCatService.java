package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * @author mengqa
 * @create 2018-05-23 16:58
 **/
public interface ItemCatService {

    List<EasyUITreeNode> getItemCatList(Long parentId);
}
