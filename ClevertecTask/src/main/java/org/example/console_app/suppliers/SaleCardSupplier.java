package org.example.console_app.suppliers;

import org.example.console_app.dto.commodities.SaleCard;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class SaleCardSupplier implements Supplier<SaleCard> {
    private final ThreadLocalRandom rnd;

    public SaleCardSupplier() {
        this.rnd = ThreadLocalRandom.current();
    }


    @Override
    public SaleCard get() {
        return SaleCard.Builder.create()
                .setId(rnd.nextLong(1000))
                .setSalePercent(30)
                .build();
    }
}
