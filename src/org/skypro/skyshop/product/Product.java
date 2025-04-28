package org.skypro.skyshop.product;

// Класс для представления продукта
public class Product {

    // Название продукта
    private final String name;

    // Стоимость продукта
    private final int price;

    // Конструктор для создания продукта с заданным именем и ценой
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Метод для получения названия продукта
    public String getName() {
        return name;
    }

    // Метод для получения цены продукта
    public int getPrice() {
        return price;
    }

    // Переопределённый метод toString для вывода информации о продукте
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + '}';
    }
}
