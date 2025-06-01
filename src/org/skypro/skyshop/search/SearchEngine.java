package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private final List<Searchable> items;

    public SearchEngine(int capacity) {
        this.items = new ArrayList<>(capacity);
    }

    public void add(Searchable item) {
        items.add(item);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
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

