package org.example.DZ4;

public class Triangle {
    public double triangle(double a, double b, double c) throws TriangleException {

        if (checkValues(a, b, c));
        double p = (a + b + c)/2;
        double s = Math.sqrt(p * (p - a)* (p - b)* (p - c));
        return s;


    }

    private static boolean checkValues(double a, double b, double c) throws TriangleException {
        if (a<=0 || b<=0 || c<=0){
            throw new TriangleException("Одно из значений треугольника неверно");
        }
        if (a + b <=c || a + c <=b || b + c <=a){
            throw new TriangleException("Треугольника не существует");
        }

        return false;
    }
}
