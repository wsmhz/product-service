package com.wsmhz.shop.product.service;

import com.wsmhz.common.business.annotation.WsmhzMicroServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created By TangBiJing
 * Description: 
 */
@EnableFeignClients("com.wsmhz")
@ComponentScan("com.wsmhz.**")
@SpringCloudApplication
@WsmhzMicroServiceApplication
public class ProductserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }
}