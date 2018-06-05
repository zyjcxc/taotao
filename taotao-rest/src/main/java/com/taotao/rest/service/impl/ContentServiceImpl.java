package com.taotao.rest.service.impl;

import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mengqa
 * @create 2018-06-05 14:50
 **/
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;

    @Override
    public List<TbContent> getContentList(long contentCid) {
        TbContentExample example = new TbContentExample();
        example.createCriteria().andCategoryIdEqualTo(contentCid);
        return contentMapper.selectByExample(example);
    }
}
