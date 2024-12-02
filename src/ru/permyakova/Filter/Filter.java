package ru.permyakova.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {
    public static <T> List<T> filterList(List<T> in, Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        for (T el : in) {
            if (filter.test(el)) result.add(el);
        }
        return result;
    }
}
