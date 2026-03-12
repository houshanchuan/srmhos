package com.mediway.hos.srm.business.center.utils;

import java.util.List;

public class SrmPage<T> {
    private int total;
    private int pages;
    private int size;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    private int current;
    private List<T> records;

    public SrmPage(int current,int limit,List<T> records){
        this.setRecords(records);
        this.setSize(limit);
        this.setCurrent(current);
        if(this.records==null){
            this.total=0;
            this.pages=0;
        }else{
            this.setTotal(this.records.size());
            if (this.total%limit== 0 ){
                //说明整除，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条数据的
                this.pages = this.total / limit;
            } else {
                //不整除，就要在加一页，来显示多余的数据。
                this.pages = this.total / limit + 1 ;
            }

        }


    }

}
