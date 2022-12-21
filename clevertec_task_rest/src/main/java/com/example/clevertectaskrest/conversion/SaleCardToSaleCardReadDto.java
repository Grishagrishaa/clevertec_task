package com.example.clevertectaskrest.conversion;

import com.example.clevertectaskrest.dao.entity.SaleCard;
import com.example.clevertectaskrest.service.dto.ReadSaleCardDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SaleCardToSaleCardReadDto implements Converter<SaleCard, ReadSaleCardDto> {
    @Override
    public ReadSaleCardDto convert(SaleCard s) {
        return ReadSaleCardDto.Builder.create()
                .setId(s.getId())
                .setNumber(s.getYear())
                .setSalePercentage(s.getSalePercentage())
                .build();
    }
}
