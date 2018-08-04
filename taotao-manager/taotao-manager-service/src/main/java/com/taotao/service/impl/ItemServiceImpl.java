package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Override
    public TbItem getItemById(long id) {
        TbItem tbItem = itemMapper.selectByPrimaryKey(id);
        return tbItem;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int row) {
        //设置分页信息
        PageHelper.startPage(page,row);
        //执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        //使用pageInfo包装分页结果
        PageInfo<TbItem> pageInfo =  new PageInfo<>(list);
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        easyUIDataGridResult.setRows(list);
        easyUIDataGridResult.setTotal(pageInfo.getTotal());
        return easyUIDataGridResult;
    }

    @Override
    public TaotaoResult addItem(TbItem item, String desc) {
        //1.生成商品id
        long itemId = IDUtils.genItemId();
        //2. 补全页面item的属性
        item.setId(itemId);
        item.setStatus((byte)1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //3.向商品表插入数据
        itemMapper.insert(item);
        //4.创建商品描述表对应的pojo
        TbItemDesc tbItemDesc = new TbItemDesc();
        //5.补全desc的pojo属性
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        //4. 向商品描述表插入数据
        itemDescMapper.insert(tbItemDesc);

        return TaotaoResult.ok();
    }
}
