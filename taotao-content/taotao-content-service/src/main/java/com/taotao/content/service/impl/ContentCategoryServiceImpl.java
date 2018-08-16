package com.taotao.content.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
