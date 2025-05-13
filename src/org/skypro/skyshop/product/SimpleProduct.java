package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private final int price;

    public SimpleProduct(String name, int price) {
        super(name); // Вызов конструктора родительского класса
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price; // Возвращаем цену для обычного продукта
    }

    @Override
    public boolean isSpecial() {
        return false; // Для обычных продуктов считаем, что они не специальные
    }

    @Override
    public String toString() {
        return getName() + ": Цена " + price; // Формируем строку с названием и ценой
    }
}
