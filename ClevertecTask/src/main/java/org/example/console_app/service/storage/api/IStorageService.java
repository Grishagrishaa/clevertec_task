package org.example.console_app.service.storage.api;

import org.example.console_app.dto.commodities.SaleCard;
import org.example.console_app.dto.commodities.api.ICommodity;

public interface IStorageService {
    ICommodity getCommodityById(Long id);

    SaleCard getSaleCardByNumber(Long id);
}
