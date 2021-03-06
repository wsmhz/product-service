package com.wsmhz.shop.product.service.service;

import com.wsmhz.common.business.service.BaseService;
import com.wsmhz.shop.product.service.api.domain.vo.CartSimpleVo;
import com.wsmhz.shop.product.service.domain.entity.Cart;
import com.wsmhz.shop.product.service.domain.vo.CartVo;

import java.util.List;

/**
 * create by tangbj on 2018/5/26
 */
public interface CartService extends BaseService<Cart> {
    /**
     * 加入购物车
     * @param cart
     * @return
     */
    Integer insertCart(Cart cart);

    /**
     * 查询购物车内是否已存在该商品
     * @param userId
     * @param productId
     * @return
     */
    Cart selectByUserIdAndProductId(Long userId, Long productId);

    /**
     * 查询该用户下的购物车
     * @param userId
     * @param checked 可为空
     * @return CartVo
     */
    CartVo selectUserCart(Long userId, Boolean checked);
    /**
     * 查询该用户下的购物车内容
     * @param userId
     * @param checked 可为空
     * @return List<Cart>
     */
    List<CartSimpleVo> selectByUserId(Long userId, Boolean checked);

}
