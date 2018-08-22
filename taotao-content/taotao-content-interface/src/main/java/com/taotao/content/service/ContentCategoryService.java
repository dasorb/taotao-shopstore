package com.taotao.content.service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

/**
 * 商品类别内容管理
 * @author chenjie
 * @date 2018/8/16 0016 - 18:31
 **/
public interface ContentCategoryService {

    List<EasyUITreeNode> getContentCategoryList(long parentId);
    TaotaoResult addContentCategory(Long parentId,String name);

    TaotaoResult renameContentCategory(Long id, String name);

    TaotaoResult deleteContentCategory(Long id);
}
