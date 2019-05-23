package com.wsmhz.shop.product.service.controller;

import com.wsmhz.common.business.response.ServerResponse;
import com.wsmhz.shop.product.service.api.api.CartApi;
import com.wsmhz.shop.product.service.api.domain.form.CartDeteleForm;
import com.wsmhz.shop.product.service.api.domain.form.UserCartForm;
import com.wsmhz.shop.product.service.api.domain.vo.CartSimpleVo;
import com.wsmhz.shop.product.service.domain.entity.Cart;
import com.wsmhz.shop.product.service.domain.vo.CartVo;
import com.wsmhz.shop.product.service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * create by tangbj on 2018/5/26
 */
@RestController
@RequestMapping("/api/cart")
public class FrontCartController implements CartApi {
    
    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public ServerResponse<CartVo> selectAll(@PathVariable("userId")Long userId){
        return  ServerResponse.createBySuccess(cartService.selectUserCart(userId,null));
    }

    @GetMapping("/{userId}/checked")
    public ServerResponse<CartVo> selectAllChecked(@PathVariable("userId")Long userId){
        return  ServerResponse.createBySuccess(cartService.selectUserCart(userId,true));
    }

    @PostMapping
    public ServerResponse<String> insert(@RequestBody Cart cart){
        Integer result = cartService.insertCart(cart);
        if(result > 0){
            return  ServerResponse.createBySuccess();
        }else{
            return  ServerResponse.createByErrorMessage("加入购物车失败");
        }
    }

    @PutMapping
    public ServerResponse<CartVo> update(@RequestBody Cart cart){
        Integer result = cartService.updateByPrimaryKeySelective(cart);
        if(result > 0){
            return  ServerResponse.createBySuccess();
        }else{
            return  ServerResponse.createByErrorMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id){

        return cartService.deleteByPrimaryKey(id);
    }

    /**************************微服务接口*************************************/

    @Override
    @PostMapping("/select/user")
    public List<CartSimpleVo> selectByUserId(@RequestBody @Valid UserCartForm userCartForm){
        return cartService.selectByUserId(userCartForm.getUserId(),userCartForm.getChecked());
    }

    @Override
    @PostMapping("/delete")
    public int deleteApi(@RequestBody @Valid CartDeteleForm cartDeteleForm){
        return cartService.deleteByPrimaryKey(cartDeteleForm.getId());
    }
}
