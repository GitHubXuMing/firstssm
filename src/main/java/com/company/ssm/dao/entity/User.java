package com.company.ssm.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private BigDecimal sal;

    private Date birth;

    public User(Integer id, String username, BigDecimal sal, Date birth) {
        this.id = id;
        this.username = username;
        this.sal = sal;
        this.birth = birth;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}