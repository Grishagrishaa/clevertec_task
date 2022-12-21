package org.example.console_app.suppliers;

import org.example.console_app.dto.commodities.Wear;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class WearSupplier implements Supplier<Wear> {
    private static final List<String> availableColors = List.of("Black", "White", "Grey", "Green", "Blue", "Purple", "Pink");
    private final ThreadLocalRandom rnd;

    public WearSupplier() {
        this.rnd = ThreadLocalRandom.current();
    }
    @Override
    public Wear get() {
        return Wear.Builder.create()
                .setId(rnd.nextLong())
                .setName("Adidas Originals")
                .setColor(availableColors.get(rnd.nextInt(availableColors.size())))
                .setSize(rnd.nextInt(50))

                .setCost(400)
                .build();

    }
}
