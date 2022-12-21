package org.example.console_app.dto.decorator;

import org.example.console_app.dto.commodities.api.ICommodity;

public class CommodityDecorator implements ICommodity {
    private final ICommodity commodity;

    public CommodityDecorator(ICommodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public Long getId() {
        return commodity.getId();
    }

    @Override
    public Integer getCost() {
        return commodity.getCost();
    }

    @Override
    public String getName() {
        return commodity.getName();
    }

    @Override
    public String toString() {
        return "name = " + commodity.getName() +
               ", cost = " + commodity.getCost() +
                '}';
    }
}
