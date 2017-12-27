package com.powergrid.integration.controller.converter;

import com.powergrid.integration.controller.vo.ProductVo;
import com.powergrid.integration.entity.Product;
import com.google.common.base.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter extends Converter<Product, ProductVo> {
    @Override
    protected ProductVo doForward(Product product) {
        return ProductVo.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .point(product.getPoint())
                        .build();
    }

    @Override
    protected Product doBackward(ProductVo productVo) {
        return Product.builder()
                        .id(productVo.getId())
                        .name(productVo.getName())
                        .point(productVo.getPoint())
                        .build();
    }
}
