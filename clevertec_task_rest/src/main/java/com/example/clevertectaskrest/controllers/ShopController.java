package com.example.clevertectaskrest.controllers;

import com.example.clevertectaskrest.controllers.api.IShopController;
import com.example.clevertectaskrest.controllers.pagination.MyPage;
import com.example.clevertectaskrest.service.IShopServiceImpl;
import com.example.clevertectaskrest.service.api.IShopService;
import com.example.clevertectaskrest.service.dto.ReadProductDto;
import com.example.clevertectaskrest.service.dto.ReadSaleCardDto;
import com.example.clevertectaskrest.service.dto.Receipt;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${app.shopController.path}")
public class ShopController implements IShopController {
    private final IShopService shopService;

    private final StringBuffer strBuff;

    public ShopController(IShopServiceImpl shopService) {
        this.shopService = shopService;
        this.strBuff = new StringBuffer();
    }

    @Override
    @PutMapping("/products")
    public ResponseEntity<String> getReceipt(@RequestParam(required = true, name = "itemId")List<Long> itemId,
                                             @RequestParam(required = false, name = "saleCardId")Long saleCardId) {
        strBuff.setLength(0);
        Receipt receipt = saleCardId == null ? shopService.getReceipt(itemId) : shopService.getReceipt(itemId, saleCardId);

        int i = 0;
        for (ReadProductDto product : receipt.getProducts()) {
            strBuff.append(String.format("%d. %s___%s RUB", ++i, product.getName(), product.getCost()));
            strBuff.append('\n');
        }

        strBuff.append("------------------");
        strBuff.append('\n');
        strBuff.append(String.format("Total Sum - %f", receipt.getTotalSum()));

        return new ResponseEntity<>(strBuff.toString(),
                                    HttpStatus.ACCEPTED);
    }

    @Override
    @GetMapping("/products")
    public ResponseEntity<MyPage<ReadProductDto>> getAllProducts(@RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                                                 @RequestParam(required = false, defaultValue = "5", name = "size") Integer size) {
        return new ResponseEntity<>(shopService.getAllProducts(PageRequest.of(page, size)),
                                    HttpStatus.OK);
    }

    @Override
    @GetMapping("/salecards")
    public ResponseEntity<MyPage<ReadSaleCardDto>> getAllSaleCards(@RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                                                   @RequestParam(required = false, defaultValue = "5", name = "size") Integer size) {
        return new ResponseEntity<>(shopService.getAllSaleCards(PageRequest.of(page, size)),
                                    HttpStatus.OK);
    }


}
