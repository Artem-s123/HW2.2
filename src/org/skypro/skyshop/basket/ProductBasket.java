package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    // Добавление продукта в корзину
    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    // Общая стоимость всех товаров
    public int getTotalPrice() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    // Вывод содержимого корзины
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        int total = 0;
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            for (Product product : entry.getValue()) {
                System.out.println(product.getName() + ": " + product.getPrice());
                total += product.getPrice();
            }
        }
        System.out.println("Итого: " + total);
    }

    // Проверка, есть ли продукт с указанным именем
    public boolean containsProduct(String productName) {
        return products.containsKey(productName);
    }

    // Очистка корзины
    public void clearBasket() {
        products.clear();
    }

    // Удаление всех товаров по имени
    public List<Product> removeByName(String name) {
        List<Product> removed = products.remove(name);
        return removed != null ? removed : new ArrayList<>();
    }
}

