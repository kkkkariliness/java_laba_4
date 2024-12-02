package ru.permyakova.Transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Transformer {
    public static <T, P> List<P> transform_list(List<T> in, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : in) {
            result.add(function.apply(item));
        }
        return result;
    }
}
