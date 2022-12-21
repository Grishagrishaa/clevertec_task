package com.example.clevertectaskrest.conversion;

import com.example.clevertectaskrest.dao.entity.Product;
import org.hibernate.annotations.Comment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToReadProductDtoConverter implements Converter<Product, com.example.clevertectaskrest.service.dto.ReadProductDto> {

    @Override
    public com.example.clevertectaskrest.service.dto.ReadProductDto convert(Product s) {
        return com.example.clevertectaskrest.service.dto.ReadProductDto.Builder.create()
                .setId(s.getId())
                .setName(s.getName())
                .setManufacturer(s.getManufacturer())
                .setWeight(s.getWeight())
                .setExpirationDate(s.getExpirationDate())
                .setCost(s.getCost())
                .setCount(s.getCount())
                .build();
    }
}
