package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容分类管理controller
 * @author chenjie
 * @date 2018/8/16 0016 - 21:47
 **/
@Controller
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    //内容分类列表显示
    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value = "id",defaultValue = "0")long parentId){
        List<EasyUITreeNode> result = contentCategoryService.getContentCategoryList(parentId);
        return result;
    }

    //新建内容分类
    @RequestMapping("/content/category/create")
    @ResponseBody
    public TaotaoResult addContentCategory(Long parentId, String name){
        TaotaoResult result = contentCategoryService.addContentCategory(parentId,name);
        return result;
    }

    //重命名内容分类
    @RequestMapping("/content/category/update")
    @ResponseBody
    public TaotaoResult renameContentCategory(Long id, String name){
        TaotaoResult result = contentCategoryService.renameContentCategory(id,name);
        return result;
    }
}
