package ru.permyakova.PointToBox;

public class Point3D extends Point {
    private final double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public String toString() {
        return "{" + super.toString().replace("}", "") + ";" + z + "}";
    }
}
