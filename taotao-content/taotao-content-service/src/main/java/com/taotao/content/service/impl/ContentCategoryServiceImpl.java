package com.taotao.content.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chenjie
 * @date 2018/8/16 0016 - 18:33
 **/
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    /************
     * 通过父id查询类别列表
     * @param parentId
     * @return
     */

    //自动导入
    @Autowired
    TbContentCategoryMapper contentCategoryMapper;


    @Override
    public List<EasyUITreeNode> getContentCategoryList(long parentId) {

        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        //执行查询
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        List<EasyUITreeNode> result = new ArrayList<>();
        for (TbContentCategory tbContentCategory : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent()?"closed":"open");
            //添加到结果列表
            result.add(node);

        }

        return result;
    }

    @Override
    public TaotaoResult addContentCategory(Long parentId, String name) {
        //1.创建pojo
        TbContentCategory tbContentCategory = new TbContentCategory();
        //2.补全pojo属性
        tbContentCategory.setParentId(parentId);
        tbContentCategory.setName(name);
        //状态：可选值1(正常）2(删除)
        tbContentCategory.setStatus(1);
        //排序，默认为1
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setIsParent(false);
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setUpdated(new Date());
        //插入到数据库中
        contentCategoryMapper.insert(tbContentCategory);
        //判断父节点的状态，更改父节点的属性
        TbContentCategory parentNode = contentCategoryMapper.selectByPrimaryKey(parentId);
        if(!parentNode.getIsParent()){
            //如果父节点为叶子节点应该改为父节点
            parentNode.setIsParent(true);
            //更改之后更新
            contentCategoryMapper.updateByPrimaryKey(parentNode);
        }
        //返回结果
        return TaotaoResult.ok(tbContentCategory);
    }

    @Override
    public TaotaoResult renameContentCategory(Long id, String name) {
        //1.先根据id查询到节点
        TbContentCategory renameNode = contentCategoryMapper.selectByPrimaryKey(id);
        renameNode.setName(name);
        //2.更新节点
        contentCategoryMapper.updateByPrimaryKey(renameNode);
        return TaotaoResult.ok(renameNode);
    }

    @Override
    public TaotaoResult deleteContentCategory(Long id) {
        //1.根据传过来的id查询到节点
        TbContentCategory deleteNode = contentCategoryMapper.selectByPrimaryKey(id);
        //2.判断一下是否是叶子节点
        if(!deleteNode.getIsParent()){
            //如果是叶子节点，直接删除
            contentCategoryMapper.deleteByPrimaryKey(id);
        }
        return null;
    }

}
