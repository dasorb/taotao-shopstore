package com.taotao.content.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * 商品类别内容管理
 * @author chenjie
 * @date 2018/8/16 0016 - 18:31
 **/
public interface ContentCategoryService {

    List<EasyUITreeNode> getContentCategoryList(long parentId);
}
