package com.mediway.hos.srm.business.center.model.vo.app;

import lombok.Data;

import java.util.List;

@Data
public class AppListVo<T> {
    private int total=0;
    private int pages=1;
    private int size=15;
    private int current;

    public String getLoadstatus() {
        return loadstatus;
    }

    public void setLoadstatus(String loadstatus) {
        this.loadstatus = loadstatus;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    private String loadstatus="loadmore";
    private List<T> rows;
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

    public AppListVo(int current,int limit,List<T> records) {
        if(!records.isEmpty()){
            List<T> smallList=records.subList(limit*(current-1),Math.min(limit*current,records.size()));//截取对应范围数据
            this.setRows(smallList);
        }
        this.setSize(limit);
        this.setCurrent(current);
        if (this.rows == null) {
            this.total = 0;
            this.pages = 0;
            this.loadstatus="nomore";
        } else {
            this.setTotal(records.size());
            if (this.total % limit == 0) {
                //说明整除，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条数据的
                this.pages = this.total / limit;
            } else {
                //不整除，就要在加一页，来显示多余的数据。
                this.pages = this.total / limit + 1;
            }
            int allCount=this.size*this.current;
            if(allCount>=this.total){
                this.loadstatus="nomore";
            }
        }
    }
    public AppListVo(int current,int limit,int total,List<T> rows) {

        this.setRows(rows);
        this.setSize(limit);
        this.setTotal(total);
        this.setCurrent(current);
        if (this.rows == null) {
            this.total = 0;
            this.pages = 0;
            this.loadstatus="nomore";
        } else {
            this.loadstatus="loadmore";
            if (this.total % limit == 0) {
                //说明整除，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条数据的
                this.pages = this.total / limit;
            } else {
                //不整除，就要在加一页，来显示多余的数据。
                this.pages = this.total / limit + 1;
            }
            int allCount=this.size*this.current;
            if(allCount>=this.total){
                this.loadstatus="nomore";
            }
        }
    }
}
