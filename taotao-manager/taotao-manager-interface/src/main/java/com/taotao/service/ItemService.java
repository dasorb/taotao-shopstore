package com.taotao.service;

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
}
