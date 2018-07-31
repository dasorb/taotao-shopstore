package com.taotao.service.impl;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenjie
 * @date 2018/7/31 0031 - 15:23
 **/
@Service
public class ItemServiceImpl implements ItemService {

    /**************
     * 无法自动装填
     */
    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(long id) {
        TbItem tbItem = itemMapper.selectByPrimaryKey(id);
        return tbItem;
    }
}
