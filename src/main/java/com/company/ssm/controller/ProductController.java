package com.company.ssm.controller;

import com.company.ssm.common.Res;
import com.company.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    IProductService productService;

    @RequestMapping(value = "products",method = RequestMethod.GET)
    public @ResponseBody Res findAll(
           @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
           @RequestParam(value = "size",required = false,defaultValue = "3") Integer size
    ){
        return productService.findAll(page,size);
    }
}
