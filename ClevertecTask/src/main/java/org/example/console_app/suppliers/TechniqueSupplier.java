package org.example.console_app.suppliers;

import org.example.console_app.dto.commodities.Technique;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class TechniqueSupplier implements Supplier<Technique> {
    private static final List<String> availableColors = List.of("Gold", "Space Gray", "Silver", "Midnight Green");
    private final ThreadLocalRandom rnd;

    public TechniqueSupplier() {
        this.rnd = ThreadLocalRandom.current();
    }

    @Override
    public Technique get() {
        return Technique.Builder.create()
                .setId(rnd.nextLong())
                .setName("IPhone 11 Pro Max")
                .setColor(availableColors.get(rnd.nextInt(availableColors.size())))
                .setWeight(226)

                .setManufactureDate(LocalDate.now())
                .setExpirationDate(LocalDate.now().plusYears(2))

                .setCost(10_000)
                .build();

    }
}
