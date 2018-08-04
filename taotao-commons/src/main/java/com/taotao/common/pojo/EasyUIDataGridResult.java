package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 响应Grid控件，向其返回对应的JSON数据
 * @author chenjie
 * @date 2018/8/2 0002 - 16:07
 **/
public class EasyUIDataGridResult implements Serializable {

    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
