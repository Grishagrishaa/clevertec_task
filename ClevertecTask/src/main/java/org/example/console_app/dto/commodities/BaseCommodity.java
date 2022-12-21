package org.example.console_app.dto.commodities;

import org.example.console_app.dto.commodities.api.ICommodity;

public abstract class BaseCommodity implements ICommodity, Comparable<BaseCommodity> {
    private final Long id;
    private final String name;
    private Integer cost;


    protected BaseCommodity(Long id, Integer cost, String name) {
        this.id = id;
        this.cost = cost;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "BaseCommodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
