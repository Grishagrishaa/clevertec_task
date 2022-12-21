package org.example.console_app.service.shop.api;

import java.util.Map;

public interface IShopService {
    String getReceipt(Map<Long, Integer> idAndCount);

    String getReceipt(Map<Long, Integer> idAndCount, Long cardNumber);

}
