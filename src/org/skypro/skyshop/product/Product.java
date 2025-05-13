package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    // Добавление абстрактного метода isSpecial
    public abstract boolean isSpecial(); // Абстрактный метод для переопределения
}
