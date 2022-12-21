package org.example.console_app.suppliers;

import org.example.console_app.dto.commodities.Grocery;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class GrocerySupplier implements Supplier<Grocery> {
    private final ThreadLocalRandom rnd;

    public GrocerySupplier() {
        this.rnd = ThreadLocalRandom.current();
    }

    @Override
    public Grocery get() {
        return Grocery.Builder.create()
                .setId(rnd.nextLong())
                .setName("Vodar")
                .setManufactureDate(LocalDateTime.now())
                .setExpirationDate(LocalDateTime.now().plusMonths(3L))

                .setCost(100)
                .build();
    }
}
