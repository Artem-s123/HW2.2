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
        return content;  // Поиск по содержанию статьи
    }

    @Override
    public String getType() {
        return "ARTICLE"; // Тип объекта
    }

    @Override
    public String getName() {
        return name; // Возвращаем имя статьи
    }

    @Override
    public String toString() {
        return "Статья: " + name;
    }
}
