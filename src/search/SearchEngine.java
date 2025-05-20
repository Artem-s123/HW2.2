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

    public Searchable[] search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : items) {
            if (item.matches(query)) {
                results.add(item);
            }
        }
        return results.toArray(new Searchable[0]);
    }
}
