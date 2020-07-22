package com.company.ssm.service;

import com.company.ssm.common.Res;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ProductServiceTest {
    @Autowired
    IProductService productService;
    @Test
    public void findAll() {
        Res result = productService.findAll(1,3);
        System.err.println(result.getStatus());
        System.err.println(result.getMsg());
        System.err.println(result.getData());
        PageInfo info = (PageInfo) result.getData();
        info.getList().stream().forEach(System.err::println);
    }
}