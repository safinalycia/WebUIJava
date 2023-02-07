package org.example.DZ4;

public class TriangleTest {
    public double triangleTest(double a, double b, double c) throws FunctionTriangle{

        if (checkValues(a, b, c));
        double p = (a + b + c)/2;
        double s = Math.sqrt(p * (p - a)* (p - b)* (p - c));
        return s;


    }

    private static boolean checkValues(double a, double b, double c) throws FunctionTriangle {
        if (a<=0 || b<=0 || c<=0){
            throw new FunctionTriangle("Одно из значений треугольника неверно");
        }
        if (a + b <=c || a + c <=b || b + c <=a){
            throw new FunctionTriangle("Треугольника не существует");
        }

        return false;
    }
}
