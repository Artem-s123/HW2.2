package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.*;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();

        // Добавление продуктов
        searchEngine.add(new SimpleProduct("Молоко", 60));
        searchEngine.add(new DiscountedProduct("Хлеб", 40, 10));
        searchEngine.add(new FixPriceProduct("Яйца", 30));

        // Добавление статей
        searchEngine.add(new Article("Преимущества молока", "Молоко полезно для здоровья..."));
        searchEngine.add(new Article("Почему хлеб важен", "Хлеб содержит много полезных веществ..."));
        searchEngine.add(new Article("Про яйца", "Яйца — источник белка и витаминов."));

        // Демонстрация поиска
        printResults("молоко", searchEngine.search("молоко"));
        printResults("хлеб", searchEngine.search("хлеб"));
        printResults("яйца", searchEngine.search("яйца"));
        printResults("арбуз", searchEngine.search("арбуз"));

        // Лучший результат
        printBestResult(searchEngine, "молоко");
        printBestResult(searchEngine, "арбуз");
    }

    private static void printResults(String query, Set<Searchable> results) {
        System.out.println("Результаты поиска по запросу: " + query);
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            results.forEach(System.out::println);
        }
        System.out.println();
    }

    private static void printBestResult(SearchEngine searchEngine, String query) {
        try {
            Searchable best = searchEngine.findBestResult(query);
            System.out.println("Лучший результат для '" + query + "': " + best);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
