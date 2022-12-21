package com.example.clevertectaskrest.controllers.api;

import com.example.clevertectaskrest.controllers.pagination.MyPage;
import com.example.clevertectaskrest.service.dto.ReadProductDto;
import com.example.clevertectaskrest.service.dto.ReadSaleCardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IShopController {
    ResponseEntity<String> getReceipt(@RequestParam(required = true, name = "productsId")List<Long> productsId,
                                     @RequestParam(required = false, name = "saleCardId")Long saleCardId);

    ResponseEntity<MyPage<ReadProductDto>> getAllProducts(@RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                                          @RequestParam(required = false, defaultValue = "5", name = "size") Integer size);

    ResponseEntity<MyPage<ReadSaleCardDto>> getAllSaleCards(@RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                                            @RequestParam(required = false, defaultValue = "5", name = "size") Integer size);

}
