package org.skypro.skyshop.search;

public class Article implements Searchable {

    private final String name;    // название статьи
    private final String content; // содержание статьи

    public Article(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
        // Для поиска используем и название, и содержание
        return name + " " + content;
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Статья: " + name;
    }
}
