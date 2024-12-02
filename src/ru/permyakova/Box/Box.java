package ru.permyakova.Box;

public class Box<T> {
    private T item;

    public boolean is_empty() {
        return item == null;
    }

    public void put_in(T item) {
        if (!is_empty()) {
            throw new IllegalStateException("В коробке уже что-то лежит!");
        }
        this.item = item;
    }

    public T put_out() {
        if (is_empty()) {
            throw new IllegalStateException("Коробка пустая!");
        }
        T temp = item;
        item = null;
        return temp;
    }
}
