package com.ruirui.demo05.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;
@Data
public class PageUtil<T> {
    private List records;
    private long total;

    public static PageUtil getInstance(IPage iPage) {
        PageUtil pageUtil = new PageUtil();
        pageUtil.setRecords(iPage.getRecords());
        pageUtil.setTotal(iPage.getTotal());
        return pageUtil;
    }
}
