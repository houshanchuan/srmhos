package com.mediway.hos.srm.business.base.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;

public class BasePO<T extends Model<?>> extends Model<T> {

    @TableField(exist = false)
    private int page;

    @TableField(exist = false)
    private int rows;

    @TableField(exist = false)
    private String sort;

    @TableField(exist = false)
    private String order;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    @TableField(exist = false)
    private String q;

    public int getPage() {
        return this.page;
    }

    public int getRows() {
        return this.rows;
    }

    public String getSort() {
        return this.sort;
    }

    public String getOrder() {
        return this.order;
    }

    public void setPage(final int page) {
        this.page = page;
    }

    public void setRows(final int rows) {
        this.rows = rows;
    }

    public void setSort(final String sort) {
        this.sort = sort;
    }

    public void setOrder(final String order) {
        this.order = order;
    }
}

