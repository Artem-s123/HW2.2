package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(10);

        // Создаем товары
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
        printResults(searchEngine.search("молоко"));
        printResults(searchEngine.search("хлеб"));
        printResults(searchEngine.search("полезно"));

        // Поиск самого подходящего результата
        try {
            Searchable best = searchEngine.findBestResult("молоко");
            System.out.println("Лучший результат по запросу 'молоко': " + best);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Searchable best = searchEngine.findBestResult("арбуз");
            System.out.println("Лучший результат по запросу 'арбуз': " + best);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void printResults(List<Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            for (Searchable item : results) {
                System.out.println(item);
            }
        }
        System.out.println();
    }
}


