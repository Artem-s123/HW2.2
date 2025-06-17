package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {

    private final Set<Searchable> items;

    public SearchEngine() {
        this.items = new HashSet<>();
    }

    public void add(Searchable item) {
        items.add(item); // HashSet не позволит добавить дубликат (если equals/hashCode работают правильно)
    }

    // 🔎 Метод поиска — теперь возвращает отсортированный TreeSet
    public Set<Searchable> search(String query) {
        Comparator<Searchable> comparator = Comparator
                .comparingInt((Searchable s) -> s.getName().length()).reversed()
                .thenComparing(Searchable::getName);

        Set<Searchable> results = new TreeSet<>(comparator);

        for (Searchable item : items) {
            if (item.matches(query)) {
                results.add(item);
            }
        }

        return results;
    }

    public Searchable findBestResult(String query) throws BestResultNotFound {
        int maxCount = 0;
        Searchable best = null;

        for (Searchable item : items) {
            String term = item.getSearchTerm();
            int count = countOccurrences(term, query);

            if (count > maxCount) {
                maxCount = count;
                best = item;
            }
        }

        if (best == null || maxCount == 0) {
            throw new BestResultNotFound(query);
        }

        return best;
    }

    private int countOccurrences(String text, String sub) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }

        return count;
    }
}
