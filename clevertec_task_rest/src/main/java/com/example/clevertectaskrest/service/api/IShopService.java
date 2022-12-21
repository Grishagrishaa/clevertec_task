package com.example.clevertectaskrest.service.api;

import com.example.clevertectaskrest.controllers.pagination.MyPage;
import com.example.clevertectaskrest.service.dto.ReadProductDto;
import com.example.clevertectaskrest.service.dto.ReadSaleCardDto;
import com.example.clevertectaskrest.service.dto.Receipt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IShopService {
    Receipt getReceipt(List<Long> ids);

    Receipt getReceipt(List<Long> ids, Long saleCardNumber);

    MyPage<ReadProductDto> getAllProducts(Pageable pageable);

    MyPage<ReadSaleCardDto> getAllSaleCards(Pageable pageable);

}
