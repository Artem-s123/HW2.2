package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        // Создаём продукты разных типов
        Product product1 = new SimpleProduct("Молоко", 90);
        Product product2 = new DiscountedProduct("Сыр", 150, 20); // скидка 20%
        Product product3 = new FixPriceProduct("Хлеб");
        Product product4 = new SimpleProduct("Чай", 130);
        Product product5 = new DiscountedProduct("Кофе", 200, 25);
        Product product6 = new FixPriceProduct("Вода");

        // Создаём корзину
        ProductBasket basket = new ProductBasket();

        // Добавляем продукты
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        // Пробуем добавить шестой продукт (не должен добавиться)
        basket.addProduct(product6);

        // Печатаем содержимое корзины
        basket.printBasket();

        // Общая стоимость
        System.out.println("Общая стоимость: " + basket.getTotalPrice());

        // Поиск товаров
        System.out.println("Есть Кофе? " + basket.containsProduct("Кофе"));
        System.out.println("Есть Сыр? " + basket.containsProduct("Сыр"));
        System.out.println("Есть Вода? " + basket.containsProduct("Вода"));

        // Очистка корзины
        basket.clearBasket();

        // Повторная печать после очистки
        basket.printBasket();
        System.out.println("Общая стоимость после очистки: " + basket.getTotalPrice());
        System.out.println("Есть Чай? " + basket.containsProduct("Чай"));
    }
}

