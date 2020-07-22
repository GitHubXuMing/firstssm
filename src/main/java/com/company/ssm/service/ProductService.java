package com.company.ssm.service;

import com.company.ssm.common.Res;
import com.company.ssm.dao.ProductDao;
import com.company.ssm.dao.entity.Product;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public Res findAll(Integer page, Integer size) {
        PageHelper.startPage((page-1)*size,size);
        List<Product> productList = productDao.findAll();
        if(productList != null && productList.size() > 0) {
            PageInfo result = new PageInfo(productList);
            return Res.success(result);
        }else {
            return Res.error();
        }
    }
}
