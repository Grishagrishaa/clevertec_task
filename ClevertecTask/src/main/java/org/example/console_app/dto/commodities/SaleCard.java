package org.example.console_app.dto.commodities;

public class SaleCard {
    private final Long id;
    private final Integer salePercent;

    public SaleCard(Long id, Integer salePercent) {
        this.id = id;
        this.salePercent = salePercent;
    }

    public SaleCard(Builder builder) {
        this.id = builder.id;
        this.salePercent = builder.salePercent;
    }

    public Long getNumber() {
        return id;
    }

    public Integer getSalePercent() {
        return salePercent;
    }

    public static class Builder{
        private Long id;
        private Integer salePercent;

        private Builder() {
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setSalePercent(Integer salePercent) {
            this.salePercent = salePercent;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public SaleCard build(){
            return new SaleCard(this);
        }
    }

    @Override
    public String toString() {
        return "SaleCard{" +
                "id=" + id +
                ", salePercent=" + salePercent +
                '}';
    }
}
