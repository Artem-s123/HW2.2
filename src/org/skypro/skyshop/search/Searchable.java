package org.skypro.skyshop.search;

public interface Searchable {

    // Возвращает текст, по которому будет выполняться поиск (например, имя + описание)
    String getSearchTerm();

    // Возвращает тип объекта — например, "PRODUCT" или "ARTICLE"
    String getType();

    // Возвращает имя объекта (например, название товара или статьи)
    String getName();

    // Возвращает строковое представление объекта (имя + тип)
    default String getStringRepresentation() {
        return getName() + " — тип " + getType();
    }

    // Метод проверки, содержится ли запрос в тексте для поиска
    default boolean matches(String query) {
        return getSearchTerm().toLowerCase().contains(query.toLowerCase());
    }
}
