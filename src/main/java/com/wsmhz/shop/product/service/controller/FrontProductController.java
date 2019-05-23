package com.wsmhz.shop.product.service.controller;

import com.github.pagehelper.PageInfo;


import com.wsmhz.common.business.response.ServerResponse;
import com.wsmhz.shop.product.service.api.api.ProductApi;
import com.wsmhz.shop.product.service.api.domain.form.ProductSelectForm;
import com.wsmhz.shop.product.service.api.domain.form.ProductUpdateForm;
import com.wsmhz.shop.product.service.api.domain.vo.ProductSimpleVo;
import com.wsmhz.shop.product.service.domain.entity.Product;
import com.wsmhz.shop.product.service.api.enums.ProductConst;
import com.wsmhz.shop.product.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * create by tangbj on 2018/5/19
 */
@RestController
@RequestMapping("/api/product")
public class FrontProductController implements ProductApi {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ServerResponse selectById(@PathVariable("id")Long id){
        return ServerResponse.createBySuccess(productService.selectById(id));
    }

    @PostMapping()
    public ServerResponse selectAllOfPage(@RequestParam(value = "pageNum")Integer pageNum,
                                                    @RequestParam(value = "pageSize")Integer pageSize,
                                                    @RequestParam(value = "keyWord",required = false)String keyWord,
                                                    @RequestParam(value = "categoryId",required = false)Long categoryId,
                                                    @RequestParam(value = "flag",required = false) ProductConst.FlagEnum flag){
        PageInfo<Product> pageInfo = productService.selectPageListByNameAndCategoryId(pageNum,pageSize,keyWord,categoryId,ProductConst.StatusEnum.ON_SALE,flag);
        return  ServerResponse.createBySuccess(pageInfo);
    }

    /**************************微服务接口*************************************/

    @Override
    @PutMapping
    public int update(@RequestBody ProductUpdateForm productUpdateForm){
        return productService.updateByPrimaryKeySelective(productUpdateForm);
    }

    @Override
    @GetMapping("/stock/{id}")
    public int selectStockByProductId(@PathVariable("id")Long id){
        return  productService.selectStockByProductId(id);
    }

    @Override
    @PostMapping("/select")
    public ProductSimpleVo selectById(@RequestBody @Valid ProductSelectForm productSelectForm){
        return  productService.selectById(productSelectForm.getId());
    }
}
