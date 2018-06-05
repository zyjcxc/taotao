package com.taotao.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mengqa
 * @create 2018-06-05 10:09
 **/
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;


    @Override
    public List<EasyUITreeNode> getCategoryList(long parentId) {

        TbContentCategoryExample example = new TbContentCategoryExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);

        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbContentCategory tbContentCategory : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
            resultList.add(node);
        }


        return resultList;
    }


    @Override
    public TaotaoResult save(TbContentCategory contentCategory) {
        try {
            long id = IDUtils.genItemId();
            Date date = new Date();
            contentCategory.setId(id);
            contentCategory.setCreated(date);
            contentCategory.setUpdated(date);
            contentCategory.setIsParent(false);
            contentCategory.setStatus(1);
            contentCategory.setSortOrder(1);
            contentCategoryMapper.insert(contentCategory);

            TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(contentCategory
                    .getParentId());
            if (!parentCat.getIsParent()) {
                parentCat.setIsParent(true);
                contentCategoryMapper.updateByPrimaryKey(parentCat);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return TaotaoResult.ok(contentCategory);
    }

    @Override
    public TaotaoResult delete(TbContentCategory contentCategory) {
        try {
            long id = contentCategory.getId();
            Long parentId = contentCategory.getParentId();
            contentCategoryMapper.deleteByPrimaryKey(id);
            TbContentCategoryExample example = new TbContentCategoryExample();
            example.createCriteria().andParentIdEqualTo(parentId);
            List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(list)) {
                TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
                parentCat.setIsParent(false);
                contentCategoryMapper.updateByPrimaryKey(parentCat);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return TaotaoResult.ok(contentCategory);
    }
}
