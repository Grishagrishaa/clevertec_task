package com.example.clevertectaskrest.service;

import com.example.clevertectaskrest.controllers.pagination.MyPage;
import com.example.clevertectaskrest.dao.entity.Product;
import com.example.clevertectaskrest.dao.entity.SaleCard;
import com.example.clevertectaskrest.service.api.IProductService;
import com.example.clevertectaskrest.service.api.ISaleCardService;
import com.example.clevertectaskrest.service.api.IShopService;
import com.example.clevertectaskrest.service.dto.ReadProductDto;
import com.example.clevertectaskrest.service.dto.ReadSaleCardDto;
import com.example.clevertectaskrest.service.dto.Receipt;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class IShopServiceImpl implements IShopService {
    private final IProductService productService;
    private final ISaleCardService saleCardService;
    private final ConversionService conversionService;
    private final ModelMapper mapper;


    public IShopServiceImpl(IProductServiceImpl productService, ISaleCardService saleCardService, ConversionService conversionService, ModelMapper mapper) {
        this.productService = productService;
        this.saleCardService = saleCardService;
        this.conversionService = conversionService;
        this.mapper = mapper;
    }


    @Override
    @Transactional
    public Receipt getReceipt(List<Long> ids) {
        ArrayList<ReadProductDto> products = buyProducts(ids);

        double sum = products.stream()
                .mapToInt(ReadProductDto::getCost)
                .sum();

        return Receipt.Builder.create()
                .setProducts(products)
                .setTotalSum(sum)
                .build();
    }

    @Override
    @Transactional
    public Receipt getReceipt(List<Long> ids, Long saleCardId) {
        ArrayList<ReadProductDto> products = buyProducts(ids);
        SaleCard saleCard = saleCardService.getSaleCardById(saleCardId);

        int sum = products.stream()
                  .mapToInt(ReadProductDto::getCost)
                  .sum();

        return Receipt.Builder.create()
                .setProducts(products)
                .setTotalSum((sum * ((100.0 - saleCard.getSalePercentage())/100)))
                .build();
    }

    @Override
    public MyPage<ReadProductDto> getAllProducts(Pageable pageable) {
        Page<Product> springPage = productService.getAll(pageable);

        List<ReadProductDto> readProductDtoList = springPage.getContent()
                .stream()
                .map(e -> conversionService.convert(e, ReadProductDto.class))
                .toList();

        MyPage<ReadProductDto> myPage = mapper.map(springPage, MyPage.class);
        myPage.setContent(readProductDtoList);
        return myPage;
    }

    @Override
    public MyPage<ReadSaleCardDto> getAllSaleCards(Pageable pageable) {
        Page<SaleCard> springPage = saleCardService.getAllSaleCards(pageable);

        List<ReadSaleCardDto> readSaleCardDtoList = springPage.getContent()
                .stream()
                .map(e -> conversionService.convert(e, ReadSaleCardDto.class))
                .toList();

        MyPage<ReadSaleCardDto> myPage = mapper.map(springPage, MyPage.class);
        myPage.setContent(readSaleCardDtoList);

        return myPage;
    }

    @Transactional
    ArrayList<ReadProductDto> buyProducts(List<Long> ids) {
        ArrayList<ReadProductDto> products = new ArrayList<>();
        for (Long id : ids) {
            Product product = productService.getById(id);

            long newCount = product.getCount() - 1;
            product.setCount(newCount);
            productService.update(product.getId(), product);

            products.add(conversionService.convert(product, ReadProductDto.class));
        }
        return products;
    }
}
