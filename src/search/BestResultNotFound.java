package org.skypro.skyshop.search;

/**
 * Исключение выбрасывается, когда не найден ни один подходящий результат поиска.
 */
public class BestResultNotFound extends Exception {

    public BestResultNotFound(String query) {
        super("Не найден подходящий результат для запроса: \"" + query + "\"");
    }
}
