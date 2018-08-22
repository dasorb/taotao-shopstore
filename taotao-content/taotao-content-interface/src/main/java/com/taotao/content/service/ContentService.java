package com.taotao.content.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * @author chenjie
 * @date 2018/8/21 0021 - 15:50
 */
public interface ContentService {

    //内容添加
    TaotaoResult addContent(TbContent content);

    //前台获取内容
    List<TbContent> getContentById(Long categoryId);
}
