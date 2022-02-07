package com.geekbrains.lesson04;

import com.geekbrains.lesson04.exception.ExceptionArgumentTriangle;

public class Triangle {

    public static double areaTriangle(int a, int b, int c) throws ExceptionArgumentTriangle {
        // The Triangle Inequality Theorem
        if (a + b < c || b + c < a || c + a < b) {
            throw new ExceptionArgumentTriangle("The Triangle Inequality Theorem states that the sum " +
                    "of any 2 sides of a triangle must be greater than the measure of the third side. " +
                    "Note: This rule must be satisfied for all 3 conditions of the sides.");
        }

        // Number must be greater than zero
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new ExceptionArgumentTriangle("Number must be greater than zero");
        }

        double s = (double) (a + b + c) / 2.0;
        double square = (s * (s - a) * (s - b) * (s - c));
        return Math.sqrt(square);

    }

}
