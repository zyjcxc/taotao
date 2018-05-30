package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author mengqa
 * @create 2018-05-30 9:46
 **/
@Service
@Transactional
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamMapper itemParamMapper;


    @Override
    public TaotaoResult findByCatId(Long itemCatId) {
        TbItemParamExample example = new TbItemParamExample();
        example.createCriteria().andItemCatIdEqualTo(itemCatId);
        List<TbItemParam> tbItemParams = itemParamMapper.selectByExampleWithBLOBs(example);
        if (!CollectionUtils.isEmpty(tbItemParams)) {
            return TaotaoResult.ok(tbItemParams.get(0));
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult save(TbItemParam itemParam) {
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        try {
            itemParamMapper.insertSelective(itemParam);
        } catch (Exception e) {
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return TaotaoResult.ok();
    }

    @Override
    public EasyUIDataGridResult getItemParamList(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        TbItemParamExample example = new TbItemParamExample();
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
