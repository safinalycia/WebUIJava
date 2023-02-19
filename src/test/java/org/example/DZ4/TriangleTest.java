package org.example.DZ4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    public static Logger logger = LoggerFactory.getLogger(TriangleTest.class);
    @Test
    void testCalcTriangleArea() throws TriangleException {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(14.696938456699069, triangle.triangle(5, 6, 7));
        logger.info("Позитивный тест: Сравнение фактического результата с ожидаемым результатом.");
    }

    @Test
    void testNegativeSideValue() throws TriangleException{
        Triangle triangle = new Triangle();
        Assertions.assertThrows(TriangleException.class, ()-> triangle.triangle(5, 6, -7));
        logger.info("Негатиный тест: Проверка при введении отрицательного значения одной из сторон.");
    }

    @Test
    void testZeroSideValue()  throws TriangleException{
        Triangle triangle = new Triangle();
        Assertions.assertThrows(TriangleException.class, ()-> triangle.triangle(5, 0, 7));
        logger.info("Негатиный тест: Проверка при введении нулевого значения одной из сторон.");
    }

    @Test
    void testSumTwoSides() throws TriangleException {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(TriangleException.class, ()-> triangle.triangle(12, 6, 7));
        logger.info("Негатиный тест: Проверка при введении значения одной из сторон, которое больше либо равно сумме двух других сторон.");
    }
}
