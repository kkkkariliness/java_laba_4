package ru.permyakova.main;

import ru.permyakova.Box.Box;
import ru.permyakova.Filter.Filter;
import ru.permyakova.PointToBox.Point;
import ru.permyakova.PointToBox.Point3D;
import ru.permyakova.PointToBox.RandomPoint3DToBox;
import ru.permyakova.Reducer.Reducer;
import ru.permyakova.Storage.Storage;
import ru.permyakova.Transformer.Transformer;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import static java.lang.System.out;

// 3 вариант
public class Main {
    public static void main(String[] args) {

        //-------------------------------------------------------------------------------------------

        // 1 (1)
        // Обобщенная коробка.
        //Создайте сущность Коробка, которая обладает следующими характеристиками:
        // Может хранить один произвольный объект в один момент времени.
        // Объект можно получить и разместить на хранение в любой момент времени.
        // Если объект забирают из коробки – ссылку на этот объект необходимо обнулить.
        // Если объект кладут в коробку, но она не пуста – необходимо выкинуть исключение.
        // Имеет метод проверки на заполненность.
        // Методы класса должны работать с тем типом данных, который был указан во время
        //создания объекта
        //Создайте Коробку которая может хранить целочисленное значение, разместите туда число 3.
        //Передайте Коробку в какой-либо метод, извлеките значение, и выведите его на экран.

        out.println("--------------------------(1 (1))-----------------------------------");

        Box<Integer> intBox = new Box<>();

        intBox.put_in(3);
        //intBox.put_in(5); // поместим ещё один объект

        int a = intBox.put_out();
        out.println("В коробке: " + a);

        //int b = intBox.put_out(); // вытащим объект ещё раз
        //out.println("В коробке: " + b);

        //--------------------------------------------------------------------------------------------

        // 1 (2)
        // Без null.
        //Создайте сущность Хранилище, которая обладает следующими характеристиками:
        // Может хранить один произвольный объект в один момент времени.
        // Хранилище неизменяемо.
        // Объект кладется в Хранилище при его создании. В качестве объекта может быть
        //сохранено также и значение null.
        // Хранилище может вернуть ссылку на Объект.
        // Если вместо объекта хранится null, необходимо вернуть какое-либо альтернативное
        //значение.
        // Метод получения значения должен работать с тем типом данных, который был указан во
        //время создания объекта
        //Выполните следующие задания:
        // Создайте Хранилище чисел, положите туда значение null. Передайте Хранилище в какой-
        //либо метод, извлеките значение, и выведите его на экран. Альтернативой должно быть
        //число 0.
        // Создайте Хранилище чисел, положите туда значение 99. Передайте Хранилище в какой-
        //либо метод, извлеките значение, и выведите его на экран. Альтернативой должно быть
        //число -1.
        // Создайте Хранилище строк, положите туда значение null. Передайте Хранилище в какой-
        //либо метод, извлеките значение, и выведите его на экран. Альтернативой должна быть
        //строка “default”.
        // Создайте Хранилище строк, положите туда значение “hello”. Передайте Хранилище в
        //какой-либо метод, извлеките значение, и выведите его на экран. Альтернативой должна
        //быть строка “hello world”.

        out.println("--------------------------(1 (2))-----------------------------------");

        Storage<Integer> null_storage = new Storage<>(null);
        Integer value1 = null_storage.Get(0);
        out.println("Значение: " + value1);

        Storage<Integer> num_storage = new Storage<>(99);
        Integer value2 = num_storage.Get(-1);
        out.println("Значение: " + value2);

        Storage<String> def_storage = new Storage<>(null);
        String value3 = def_storage.Get("default");
        out.println("Значение: " + value3);

        Storage<String> str_storage = new Storage<>("hello");
        String value4 = str_storage.Get("hello world");
        out.println("Значение: " + value4);

        //----------------------------------------------------------------------------------------------------

        // 2 (3)
        // Начало отсчета.
        //Создайте метод, принимающий Коробку из задачи 3.1.1, и кладет в неё трехмерную точку
        //координат (из задачи 2.1.5) с произвольными значениями. Метод должен позволять передавать
        //Коробку с более чем одним видом параметризации.

        out.println("--------------------------(2 (3))-----------------------------------");

        Box<Point3D> point3D_box = new Box<>();

        RandomPoint3DToBox.putRandomPointInBox(point3D_box);

        Point3D point1 = point3D_box.put_out();
        out.println("Точка 1: " + point1);

        Box<Point> point_box = new Box<>();

        RandomPoint3DToBox.putRandomPointInBox(point_box);

        Point point2 = point_box.put_out();
        out.println("Точка 2: " + point2);

        //----------------------------------------------------------------------------------------------------

        // 3 (1)
        // Функция.
        //Разработайте такой метод, который будет принимать список значений типа T, и объект имеющий
        //единственный метод apply. Данный метод надо применить к каждому элементу списка, и вернуть
        //новый список значений типа P, при этом типы T и P могут совпадать, а могут не совпадать.
        //Используйте разработанный метод следующим образом:
        //1. Передайте в метод список со значениями:“qwerty”, “asdfg”, “zx”, а получите список чисел,
        //где каждое число соответствует длине каждой строки.
        //2. Передайте в метод список со значениями: 1,-3,7, а получите список в котором все
        //отрицательные числа стали положительными, а положительные остались без изменений
        //3. Передайте в метод список состоящий из массивов целых чисел, а получите список в
        //котором будут только максимальные значения каждого из исходных массивов

        out.println("--------------------------(3 (1))-----------------------------------");

        // 1
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<Integer> lengths_of_strings = Transformer.transform_list(strings, String::length);
        out.println("Длины: " + lengths_of_strings);

        // 2
        List<Integer> numbers = List.of(1, -3, 7);
        List<Integer> positive_numbers = Transformer.transform_list(numbers, Math::abs);
        out.println("Положительные: " + positive_numbers);

        // 3
        List<int[]> arrays = List.of(new int[]{2, 6, 7}, new int[]{-10, -2, -14}, new int[]{22, 45, 312});
        List<Integer> max_values = Transformer.transform_list(arrays, el -> Arrays.stream(el).max().orElseThrow());
        out.println("Максимумы: " + max_values);

        //---------------------------------------------------------------------------------------------------

        // 3 (2)
        // Фильтр.
        //Разработайте такой метод, который будет принимать список значений типа T и объект имеющий
        //единственный метод test (принимает T и возвращает boolean). Верните новый список типа T, из
        //которого удалены все значения не прошедшие проверку условием.
        //Используйте разработанный метод следующим образом:
        //1. Передайте в метод список со значениями: “qwerty”, “asdfg”, “zx”, и отфильтруйте все
        //строки имеющие менее трех символов
        //2. Передайте в метод список со значениями: 1,-3,7, и отфильтруйте все положительные
        //элементы
        //3. Передайте в метод список состоящий из массивов целых чисел, а получите список в
        //котором будут только те массивы, в которых нет ни одного положительного элемента

        out.println("--------------------------(3 (2))-----------------------------------");

        // 1
        List<String> str = List.of("qwerty", "asdfg", "zx");
        List<String> filteredStrings = Filter.filterList(str, s -> s.length() >= 3);
        out.println("Длина >= 3: " + filteredStrings);

        // 2
        List<Integer> num = List.of(1, -3, 7);
        List<Integer> negativeNumbers = Filter.filterList(num, n -> n < 0);
        out.println("Отрицательные: " + negativeNumbers);

        // 3
        List<int[]> arra = List.of(new int[]{1, -5, 3}, new int[]{-3, -1, -7}, new int[]{-10, -22, -35});
        List<int[]> filteredArrays = Filter.filterList(arra, arr -> Arrays.stream(arr).allMatch(n -> n <= 0));
        out.println("Без положительных: ");
        filteredArrays.forEach(arr -> out.println(Arrays.toString(arr)));

        //--------------------------------------------------------------------------------------------------

        // 3 (3)
        // Сокращение.
        //Разработайте такой метод, который будет принимать список значений типа T и способ с помощью
        //которого список значений можно свести к одному значению типа T, которое и возвращается из
        //метода.
        //Используйте разработанный метод следующим образом:
        //1. Передайте в метод список со значениями: “qwerty”, “asdfg”, “zx”, и сформируйте одну
        //большую строку, которая состоит из всех строк исходного списка.
        //2. Передайте в метод список со значениями: 1,-3,7, и верните сумму всех значений исходного
        //списка.
        //3. Имеется список, состоящий из списков целых чисел, получите общеe количество
        //элементов во всех списках. Подсказка: решить задачу можно в одно действие или
        //последовательно использовать методы из 3.3.1 и 3.3.3.
        //Далее необходимо изменить разработанный метод таким образом, чтобы данный метод
        //гарантированно не возвращал null и не выбрасывал ошибок в том случае, если исходный список
        //пуст.

        out.println("--------------------------(3 (3))-----------------------------------");

        // 1
        List<String> str2 = List.of("qwerty", "asdfg", "zx");
        String str2_to_1 = Reducer.reduce_list(str2, "", (s1, s2) -> s1 + s2);
        out.println("Если в одну строку: " + str2_to_1);

        // 2
        List<Integer> num2 = List.of(1, -3, 7);
        int sum = Reducer.reduce_list(num2, 0, Integer::sum);
        out.println("Сумма: " + sum);

        // 3
        List<List<Integer>> lists_of_numbers = List.of(List.of(2, 3, 8), List.of(9, 5), List.of(), List.of(-1, 2, 12, 9));
        List<Integer> sizes = Transformer.transform_list(lists_of_numbers, List::size); // делаем список размеров через 3.1.1
        int count = Reducer.reduce_list(sizes, 0, Integer::sum);
        System.out.println("Кол-во элементов во всех списках: " + count);

        // Если пусто
        List<Integer> empty_list = new ArrayList<>();
        int res = Reducer.reduce_list(empty_list, 0, Integer::sum);
        out.println("Если пусто: " + res);


        //---------------------------------------------------------------------------------------------------

        // 3 (4)
        //Коллекционирование.
        //Разработайте такой метод, который будет возвращать коллекцию типа P со значениями типа T.
        //Данный метод будет принимать:
        //1. Список исходных значений
        //2. Способ создания результирующей коллекции
        //3. Способ передачи значений исходного списка в результирующую коллекцию.
        //Используйте разработанный метод следующим образом:
        //1. Передайте в метод список со значениями: 1,-3,7, и верните их разбитыми на два
        //подсписка, в одном из которых будут только положительные числа, а в другом только
        //отрицательные.
        //2. Передайте в метод список со значениями: “qwerty”, “asdfg”, “zx”, “qw” и верните их
        //разбитыми на подсписки таким образом, чтобы в любом подсписке были строки только
        //одинаковой длины
        //3. Передайте в метод список со значениями: “qwerty”, “asdfg”, “qwerty”, “qw” и верните набор
        //такого вида, который не может содержать одинаковые объекты.

        out.println("--------------------------(3 (4))-----------------------------------");

    }
}