package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * @author chenjie
 * @date 2018/8/3 0003 - 10:04
 **/
public interface ItemCatService {

    List<EasyUITreeNode> getItemCatList(long parentId);
}
