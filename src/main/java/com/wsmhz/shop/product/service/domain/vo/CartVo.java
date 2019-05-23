package com.wsmhz.shop.product.service.domain.vo;


import com.wsmhz.shop.product.service.domain.dto.CartProductDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * create by tangbj on 2018/5/26
 */
@Data
public class CartVo {

    private List<CartProductDto> cartProductList;

    private BigDecimal cartTotalPrice;

    private Boolean allChecked;//是否已经都勾选

}
