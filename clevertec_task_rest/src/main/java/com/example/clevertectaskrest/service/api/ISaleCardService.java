package com.example.clevertectaskrest.service.api;

import com.example.clevertectaskrest.dao.entity.SaleCard;
import com.example.clevertectaskrest.service.dto.ReadSaleCardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISaleCardService {
   SaleCard save(SaleCard saleCard);

   SaleCard getSaleCardById(Long id);

   Page<SaleCard> getAllSaleCards(Pageable pageable);

   SaleCard update(Long id, SaleCard saleCard);

   void deleteById(Long id);

}
