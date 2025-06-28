package org.skypro.skyshop.search;

import java.util.Objects;

public class Article implements Searchable {

    private final String name;    // название статьи
    private final String content; // содержание статьи

    public Article(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return name.equals(article.name);
    }
}
