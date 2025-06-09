package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {

    private final List<Searchable> items;

    public SearchEngine(int capacity) {
        this.items = new ArrayList<>(capacity);
    }

    public void add(Searchable item) {
        items.add(item);
    }

    // 🔄 Обновлённый метод поиска — теперь возвращает отсортированную Map
    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();
        for (Searchable item : items) {
            if (item.matches(query)) {
                results.put(item.getName(), item); // ключ = имя, значение = сам объект
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
