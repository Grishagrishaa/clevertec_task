package org.example.console_app.dto.commodities;

import java.time.LocalDate;

public class Technique extends BaseCommodity {
    private final LocalDate manufactureDate;
    private final LocalDate expirationDate;
    private final String color;
    private final Integer weight;

    public Technique(Long id, Integer cost, String name, LocalDate manufactureDate, LocalDate expirationDate, String color, Integer weight) {
        super(id, cost, name);
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.color = color;
        this.weight = weight;
    }

    public Technique(Builder builder) {
        super(builder.id, builder.cost, builder.name);
        this.manufactureDate = builder.manufactureDate;
        this.expirationDate = builder.expirationDate;
        this.color =builder.color;
        this.weight = builder.weight;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getColor() {
        return color;
    }

    public Integer getWeight() {
        return weight;
    }

    public static class Builder{
        private Long id;
        private String name;
        private LocalDate manufactureDate;
        private LocalDate expirationDate;
        private String color;
        private Integer weight;

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

        public Builder setManufactureDate(LocalDate manufactureDate) {
            this.manufactureDate = manufactureDate;
            return this;
        }

        public Builder setExpirationDate(LocalDate expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setWeight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public Technique build(){
            return new Technique(this);
        }
    }

    @Override
    public int compareTo(BaseCommodity o) {
        return getCost().compareTo(o.getCost());
    }

    @Override
    public String toString() {
        return "Technique{"  +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", cost=" + super.getCost() +
                "manufactureDate=" + manufactureDate +
                ", expirationDate=" + expirationDate +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
