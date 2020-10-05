package com.example.demo.comm;

import java.util.ArrayList;
import java.util.List;

public class ResPage {

    private long total;

    private List rows;

    public ResPage() {
        this.total = 0L;
        this.rows = new ArrayList();
    }

    public ResPage(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
