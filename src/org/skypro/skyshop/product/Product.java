package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    // Реализация метода из Searchable
    @Override
    public String getSearchTerm() {
        return name;
    }

    // Абстрактный метод getType обязаны реализовать наследники
    @Override
    public abstract String getType();

    // default реализация matches для удобства поиска по имени
    @Override
    public boolean matches(String query) {
        return name.toLowerCase().contains(query.toLowerCase());
    }
}
