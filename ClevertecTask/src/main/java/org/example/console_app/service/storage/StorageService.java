package org.example.console_app.service.storage;

import org.example.console_app.dto.commodities.Grocery;
import org.example.console_app.dto.commodities.SaleCard;
import org.example.console_app.dto.commodities.Technique;
import org.example.console_app.dto.commodities.Wear;
import org.example.console_app.dto.commodities.api.ICommodity;
import org.example.console_app.dto.decorator.DiscountCommodity;
import org.example.console_app.service.storage.api.IStorageService;
import org.example.console_app.suppliers.GrocerySupplier;
import org.example.console_app.suppliers.SaleCardSupplier;
import org.example.console_app.suppliers.TechniqueSupplier;
import org.example.console_app.suppliers.WearSupplier;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StorageService implements IStorageService {
    private final Map<Long, Queue<? extends ICommodity>> productStorage;
    private final List<SaleCard> saleCards;


    public StorageService() {
        this.productStorage = new HashMap<>();
        PriorityQueue<Wear> wearQueue = Stream.generate(new WearSupplier())
                                              .limit(10)
                                              .collect(Collectors.toCollection(PriorityQueue::new));
        PriorityQueue<DiscountCommodity> discountCommodityQueue = Stream.generate(new WearSupplier())
                .limit(5)
                .map(DiscountCommodity::new)
                .collect(Collectors.toCollection(PriorityQueue::new));

        PriorityQueue<Grocery> groceryQueue = Stream.generate(new GrocerySupplier())
                                              .limit(10)
                                              .collect(Collectors.toCollection(PriorityQueue::new));
        PriorityQueue<Technique> techniqueQueue = Stream.generate(new TechniqueSupplier())
                                              .limit(10)
                                              .collect(Collectors.toCollection(PriorityQueue::new));

        this.productStorage.put(1L, wearQueue);
        this.productStorage.put(2L, groceryQueue);
        this.productStorage.put(3L, techniqueQueue);
        this.productStorage.put(4L, discountCommodityQueue);


        this.saleCards = Stream.generate(new SaleCardSupplier())
                               .limit(10)
                               .toList();
        System.out.println(String.format("Accessible saleCards - %s", saleCards));
    }

    @Override
    public ICommodity getCommodityById(Long id) {
        return productStorage.get(id).remove();
    }

    @Override
    public SaleCard getSaleCardByNumber(Long number) throws IllegalArgumentException {
        for (SaleCard saleCard : saleCards) {
            if(Objects.equals(saleCard.getNumber(), number)){
                return saleCard;
            }
        }
        throw new IllegalArgumentException();
    }
}
