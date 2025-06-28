package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    // Добавление продукта в корзину
    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    // Общая стоимость всех товаров — теперь через Stream API
    public int getTotalPrice() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    // Печать корзины — теперь через forEach
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> System.out.println(product.getName() + ": " + product.getPrice()));

        System.out.println("Итого: " + getTotalPrice());
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

