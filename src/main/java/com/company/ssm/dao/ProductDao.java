package com.company.ssm.dao;

import com.company.ssm.dao.entity.Product;

import java.util.List;

public interface ProductDao {
    int deleteByPrimaryKey(Integer pid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> findAll();
}