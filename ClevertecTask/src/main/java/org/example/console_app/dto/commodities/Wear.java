package org.example.console_app.dto.commodities;

public class Wear extends BaseCommodity{
    private final Integer size;
    private final String color;

    public Wear(Long id, Integer cost, String name, Integer size, String color) {
        super(id, cost, name);
        this.size = size;
        this.color = color;
    }

    public Wear(Builder builder) {
        super(builder.id, builder.cost, builder.name);
        this.size = builder.size;
        this.color = builder.color;
    }

    public Integer getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public static class Builder{
        private Long id;
        private String name;
        private Integer size;
        private String color;

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

        public Builder setSize(Integer size) {
            this.size = size;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public Wear build(){
            return new Wear(this);
        }
    }

    @Override
    public int compareTo(BaseCommodity o) {
        return getCost().compareTo(o.getCost());
    }

    @Override
    public String toString() {
        return "Wear{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", cost=" + super.getCost() +
                ", size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}
