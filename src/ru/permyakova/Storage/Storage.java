package ru.permyakova.Storage;

public class Storage<T> {
    private final T item;

    public Storage(T item) {
        this.item = item;
    }

    public T Get(T alt_item) {
        return item != null ? item : alt_item;
    }
}
