package ru.permyakova.PointToBox;

import ru.permyakova.Box.Box;

public class RandomPoint3DToBox {
    public static void putRandomPointInBox(Box<? super Point3D> box) {
        Point3D random_point = new Point3D(Math.round((Math.random() * 20 - 10) * 100.0) / 100.0, Math.round((Math.random() * 20 - 10) * 100.0) / 100.0, Math.round((Math.random() * 20 - 10) * 100.0) / 100.0);
        box.put_in(random_point);
    }
}
