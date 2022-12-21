package org.example.console_app.dto.decorator;

import org.example.console_app.dto.commodities.api.ICommodity;

public class DiscountCommodity extends CommodityDecorator implements Comparable<DiscountCommodity> {
    public DiscountCommodity(ICommodity commodity) {
        super(commodity);
    }

    private Integer getDiscountPercentage(){
        return 10;
    }

    @Override
    public Integer getCost() {
        return (int) (super.getCost() * ((100.0 - getDiscountPercentage())/100.0));
    }

    @Override
    public String getName() {
        return super.getName() + "| On Discount";
    }



    @Override
    public int compareTo(DiscountCommodity o) {
        return getCost().compareTo(o.getCost());
    }

    @Override
    public String toString() {
        return "DiscountCommodity{" +
                super.toString();
    }
}
