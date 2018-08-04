package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * @author chenjie
 * @date 2018/7/31 0031 - 15:16
 **/
public interface ItemService {

    /**
     * 通过id查询商品信息
     * @param id
     * @return
     */
    TbItem getItemById(long id);

    /**
     * 商品列表
     * @param page
     * @param row
     * @return
     */
    EasyUIDataGridResult getItemList(int page,int row);

    /**
     * 商品添加
     * @param item
     * @param desc
     * @return
     */
    TaotaoResult addItem(TbItem item,String desc);
}
