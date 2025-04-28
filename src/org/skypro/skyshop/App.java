package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Кофе", 250);
        Product product2 = new Product("Чай", 150);
        Product product3 = new Product("Шоколад", 300);
        Product product4 = new Product("Печенье", 200);
        Product product5 = new Product("Вода", 100);
        Product product6 = new Product("Молоко", 180);

        ProductBasket basket = new ProductBasket();

        // Добавление продуктов
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        // Попытка добавить лишний продукт
        basket.addProduct(product6);

        // Печать содержимого корзины
        basket.printBasket();

        // Общая стоимость корзины
        System.out.println("Общая стоимость: " + basket.getTotalPrice());

        // Поиск товаров
        System.out.println("Есть Кофе? " + basket.containsProduct("Кофе"));
        System.out.println("Есть Сыр? " + basket.containsProduct("Сыр"));

        // Очистка корзины
        basket.clearBasket();

        // Печать пустой корзины
        basket.printBasket();

        // Общая стоимость пустой корзины
        System.out.println("Общая стоимость после очистки: " + basket.getTotalPrice());

        // Поиск в пустой корзине
        System.out.println("Есть Чай? " + basket.containsProduct("Чай"));
    }
}

