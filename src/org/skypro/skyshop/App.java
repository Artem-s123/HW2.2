package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(10);

        // Создаем товары (предположим, у тебя есть классы SimpleProduct, DiscountedProduct и т.д.)
        Product product1 = new SimpleProduct("Молоко", 60);
        Product product2 = new DiscountedProduct("Хлеб", 40, 10);
        searchEngine.add(product1);
        searchEngine.add(product2);

        // Создаем статьи
        Article article1 = new Article("Преимущества молока", "Молоко полезно для здоровья...");
        Article article2 = new Article("Почему хлеб важен", "Хлеб содержит много полезных веществ...");
        searchEngine.add(article1);
        searchEngine.add(article2);

        // Поиск
        Searchable[] results = searchEngine.search("молоко");
        System.out.println(Arrays.toString(results));

        results = searchEngine.search("хлеб");
        System.out.println(Arrays.toString(results));

        results = searchEngine.search("полезно");
        System.out.println(Arrays.toString(results));
    }
}
