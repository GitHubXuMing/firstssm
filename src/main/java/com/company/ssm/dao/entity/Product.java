package com.company.ssm.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer pid;

    private String pname;

    private BigDecimal price;

    private Date pdate;

    public Product(Integer pid, String pname, BigDecimal price, Date pdate) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.pdate = pdate;
    }

    public Product() {
        super();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", pdate=" + pdate +
                '}';
    }
}