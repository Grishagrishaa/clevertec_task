package org.example.console_app.dto.commodities;

import java.time.LocalDateTime;

public class Grocery extends BaseCommodity{
    private final LocalDateTime manufactureDate;
    private final LocalDateTime expirationDate;

    public Grocery(Long id, Integer cost, String name, LocalDateTime manufactureDate, LocalDateTime expirationDate) {
        super(id, cost, name);
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
    }

    public Grocery(Builder builder) {
        super(builder.id, builder.cost, builder.name);
        this.manufactureDate = builder.manufactureDate;
        this.expirationDate = builder.expirationDate;
    }

    public LocalDateTime getManufactureDate() {
        return manufactureDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public static class Builder{
        private Long id;
        private String name;
        private LocalDateTime manufactureDate;
        private LocalDateTime expirationDate;

        private Integer cost;


        private Builder() {
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCost(Integer cost) {
            this.cost = cost;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setManufactureDate(LocalDateTime manufactureDate) {
            this.manufactureDate = manufactureDate;
            return this;
        }

        public Builder setExpirationDate(LocalDateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public Grocery build(){
            return new Grocery(this);
        }
    }


    @Override
    public int compareTo(BaseCommodity o) {
        return getCost().compareTo(o.getCost());
    }

    @Override
    public String toString() {
        return "Grocery{"  +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", cost=" + super.getCost() +
                "manufactureDate=" + manufactureDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
