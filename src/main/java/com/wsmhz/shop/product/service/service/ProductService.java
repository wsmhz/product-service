package com.wsmhz.shop.product.service.service;

import com.github.pagehelper.PageInfo;
import com.wsmhz.common.business.service.BaseService;
import com.wsmhz.shop.product.service.api.domain.form.ProductUpdateForm;
import com.wsmhz.shop.product.service.api.domain.vo.ProductSimpleVo;
import com.wsmhz.shop.product.service.domain.entity.Product;
import com.wsmhz.shop.product.service.api.enums.ProductConst;

/**
 * create by tangbj on 2018/5/19
 */
public interface ProductService extends BaseService<Product> {
    /**
     * 商品列表 （带搜索）
     * @param pageNum
     * @param pageSize
     * @param name 商品名称 可为空
     * @param categoryId 分类ID 可为空
     * @param status 状态 可为空
     * @param flag 标识 可为空
     * @return
     */
    PageInfo<Product> selectPageListByNameAndCategoryId(Integer pageNum, Integer pageSize, String name, Long categoryId, ProductConst.StatusEnum status, ProductConst.FlagEnum flag);

    /**
     * 根据产品ID查询库存
     * @param id
     * @return 库存
     */
    int selectStockByProductId(Long id);

    ProductSimpleVo selectById(Long id);

    int updateByPrimaryKeySelective (ProductUpdateForm productUpdateForm);
}
