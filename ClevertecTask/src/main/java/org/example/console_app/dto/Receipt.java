package org.example.console_app.dto;

import org.example.console_app.dto.commodities.api.ICommodity;

import java.util.List;

public class Receipt {
    private final List<ICommodity> commodityList;
    private final Integer totalSum;

    public Receipt(List<ICommodity> commodityList, Integer totalSum) {
        this.commodityList = commodityList;
        this.totalSum = totalSum;
    }

    public Receipt(Builder builder) {
        this.commodityList = builder.commodityList;
        this.totalSum = builder.totalSum;
    }

    public List<ICommodity> getCommodityList() {
        return commodityList;
    }

    public Integer getTotalSum() {
        return totalSum;
    }

    public static class Builder{
        private List<ICommodity> commodityList;
        private Integer totalSum;

        private Builder() {
        }

        public Builder setCommodityList(List<ICommodity> commodityList) {
            this.commodityList = commodityList;
            return this;
        }

        public Builder setTotalSum(Integer totalSum) {
            this.totalSum = totalSum;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public Receipt build(){
            return new Receipt(this);
        }
    }
}
