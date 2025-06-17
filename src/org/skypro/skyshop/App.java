package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.*;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();

        // Добавляем продукты
        Product product1 = new SimpleProduct("Молоко", 60);
        Product product2 = new DiscountedProduct("Хлеб", 40, 10);
        Product product3 = new FixPriceProduct("Яйца", 30);

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);

        // Добавляем статьи
        Article article1 = new Article("Преимущества молока", "Молоко полезно для здоровья...");
        Article article2 = new Article("Почему хлеб важен", "Хлеб содержит много полезных веществ...");
        Article article3 = new Article("Про яйца", "Яйца — источник белка и витаминов.");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        // Демонстрация поиска
        printResults("молоко", searchEngine.search("молоко"));
        printResults("хлеб", searchEngine.search("хлеб"));
        printResults("яйца", searchEngine.search("яйца"));
        printResults("арбуз", searchEngine.search("арбуз"));

        // Демонстрация лучшего результата
        try {
            Searchable best = searchEngine.findBestResult("молоко");
            System.out.println("Лучший результат для 'молоко': " + best);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Searchable best = searchEngine.findBestResult("арбуз");
            System.out.println("Лучший результат для 'арбуз': " + best);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void printResults(String query, Set<Searchable> results) {
        System.out.println("Результаты поиска по запросу: " + query);
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

