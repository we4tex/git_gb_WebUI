package com.geekbrains.lesson04;

import com.geekbrains.lesson04.exception.ExceptionArgumentTriangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeEach
    void logging() {
        logger.error("Log error");
        logger.trace("Log trace");
    }

    @Test
    @DisplayName("Checking by assert")
    void checkAreaEquals() throws ExceptionArgumentTriangle {
        assertEquals(6.0, Triangle.areaTriangle(3, 4, 5));
    }

    @Test
    @DisplayName("Positive tests")
    void checkAreaPositive() {
        assertAll(() -> assertEquals(6.49, Triangle.areaTriangle(3, 5, 7), 0.01),
                () -> assertEquals(10.2, Triangle.areaTriangle(3, 7, 7), 0.1),
                () -> assertEquals(11.618, Triangle.areaTriangle(4, 6, 8), 0.001));
    }

    @Test
    @DisplayName("Negative tests: The Triangle Inequality Theorem")
    void checkIncorrectArgument() {
        assertAll(() -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(3, 1, 1);
                }, "One side of a triangle is greater than the sum of the other 2 sides"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(2, 5, 2);
                }, "One side of a triangle is greater than the sum of the other 2 sides"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(3, 3, 7);
                }, "One side of a triangle is greater than the sum of the other 2 sides")
        );
        logger.info("Logging message: {}", "The Triangle Inequality Theorem");
    }

    @Test
    @DisplayName("Negative tests: Number must be greater than zero")
    void checkCorrectArgument() {
        assertAll(() -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(-1, 1, 1);
                }, "Number must be greater than zero"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(2, -2, 2);
                }, "Number must be greater than zero"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(3, 3, -3);
                }, "Number must be greater than zero"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(0, 1, 1);
                }, "Number must be greater than zero"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(2, 0, 2);
                }, "Number must be greater than zero"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(3, 3, 0);
                }, "Number must be greater than zero"));
        logger.info("Logging message: {}", "Number must be greater than zero");
    }

}
