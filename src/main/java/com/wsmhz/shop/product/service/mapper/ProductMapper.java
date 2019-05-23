package com.wsmhz.shop.product.service.mapper;

import com.wsmhz.common.business.tkMapper.MyBaseMapper;
import com.wsmhz.shop.product.service.domain.entity.Product;


/**
 * create by tangbj on 2018/5/18
 */
public interface ProductMapper extends MyBaseMapper<Product> {
    int selectStockByProductId(Long id);
}
