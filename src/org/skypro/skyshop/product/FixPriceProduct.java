package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final int FIXED_PRICE = 500; // Фиксированная цена

    public FixPriceProduct(String name) {
        super(name); // Вызываем конструктор родительского класса
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE; // Возвращаем фиксированную цену
    }

    @Override
    public boolean isSpecial() {
        return true; // Продукт с фиксированной ценой считается специальным
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE; // Формируем строку
    }
}
