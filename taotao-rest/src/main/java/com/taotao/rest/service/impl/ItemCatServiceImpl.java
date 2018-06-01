package com.taotao.rest.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengqa
 * @create 2018-06-01 14:37
 **/
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper catMapper;

    @Override
    public CatResult getItemCatList() {
        CatResult catResult = new CatResult();
        catResult.setData(getCatList(0));
        return catResult;
    }

    private List<?> getCatList(long parentId) {
        TbItemCatExample ex = new TbItemCatExample();

        ex.createCriteria().andParentIdEqualTo(parentId);
        List resultList = new ArrayList<>();
        List<TbItemCat> list = catMapper.selectByExample(ex);
        int count = 0;
        for (TbItemCat tbItemCat : list) {
            if (tbItemCat.getIsParent()) {
                CatNode node = new CatNode();
                if (parentId == 0) {
                    node.setName("<a href='/products/" + tbItemCat.getId() + ".html'>" + tbItemCat.getName() + "</a>");
                } else {
                    node.setName(tbItemCat.getName());
                }
                node.setUrl("/products/" + tbItemCat.getId() + ".html");
                node.setItem(getCatList(tbItemCat.getId()));
                resultList.add(node);
                count ++;
                if (parentId == 0 && count >= 14) {
                    break;
                }
            } else {
                resultList.add("/products/" + tbItemCat.getId() + ".html|" + tbItemCat.getName());
            }

        }
        return resultList;
    }
}
