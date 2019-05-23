package com.wsmhz.shop.product.service.controller;


import com.wsmhz.common.business.response.ServerResponse;
import com.wsmhz.shop.product.service.domain.entity.Category;
import com.wsmhz.shop.product.service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by tangbj on 2018/5/19
 */
@RestController
@RequestMapping("/api/category")
public class FrontCategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ServerResponse<List<Category>> selectAll(){
        return  ServerResponse.createBySuccess(categoryService.selectAllWithChildren(new Integer(0).longValue()));
    }

    @GetMapping("/{id}")
    public ServerResponse<List<Category>> selectByParentId(@PathVariable("id")Long id){
        return  ServerResponse.createBySuccess(categoryService.selectByParentId(id));
    }


}
