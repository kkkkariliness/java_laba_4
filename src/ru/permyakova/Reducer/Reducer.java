package ru.permyakova.Reducer;

import java.util.List;
import java.util.function.BinaryOperator;

public class Reducer {
    public static <T> T reduce_list(List<T> in, T res_else, BinaryOperator<T> oper) {
        if (in == null || in.isEmpty()) return res_else;
        T res = res_else;
        for (T item : in) {
            res = oper.apply(res, item);
        }
        return res;
    }
}
