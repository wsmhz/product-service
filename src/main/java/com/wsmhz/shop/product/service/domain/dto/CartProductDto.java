package com.wsmhz.shop.product.service.domain.dto;


import com.wsmhz.shop.product.service.api.enums.ProductConst;
import lombok.Data;

import java.math.BigDecimal;

/**
 * create by tangbj on 2018/5/26
 */
@Data
public class CartProductDto {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer quantity;

    private String productName;

    private String productSubtitle;

    private String productMainImage;

    private BigDecimal productPrice;

    private ProductConst.StatusEnum productStatus;

    private BigDecimal productTotalPrice;

    private Integer productStock;

    private Boolean productChecked;

    private Boolean stockEnough; //库存是否充足
}
