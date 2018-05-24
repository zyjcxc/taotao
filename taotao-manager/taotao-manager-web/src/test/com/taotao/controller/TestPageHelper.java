package com.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author mengqa
 * @create 2018-05-24 9:32
 **/
public class TestPageHelper {

    @Test
    public void testPageHelper() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

        TbItemMapper mapper = ac.getBean(TbItemMapper.class);

        TbItemExample example = new TbItemExample();

        PageHelper.startPage(1, 10);

        example.createCriteria().andIdEqualTo(536563L);
        List<TbItem> list = mapper.selectByExample(example);

        for (TbItem tbItem : list) {
            System.out.println(tbItem.getTitle());
        }
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);

        System.out.println(pageInfo.getTotal());

    }

}
