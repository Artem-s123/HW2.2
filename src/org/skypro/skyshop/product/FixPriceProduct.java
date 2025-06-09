package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private final int price;

    public FixPriceProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть строго больше 0.");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false; // или true, если нужно пометить как спец. товар
    }

    @Override
    public String getType() {
        return "PRODUCT"; // Тип объекта для поиска
    }

    @Override
    public String toString() {
        return getName() + ": фиксированная цена " + price;
    }

    @Override
    public String getSearchTerm() {
        return getName(); // Поиск по названию
    }
}
