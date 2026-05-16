package hometask.utils;

import hometask.figures.Circle;
import hometask.figures.Rectangle;
import hometask.figures.Square;
import hometask.figures.RightTriangle;
import hometask.figures.IsoscelesTrapezoid;

import java.lang.reflect.Method;

public class AnnotationScanner {
    public void printDefaultAreas() {
        Class<?>[] figures = {
                Circle.class,
                Square.class,
                Rectangle.class,
                RightTriangle.class,
                IsoscelesTrapezoid.class
        };

        for (Class<?> figure : figures) {
            Method[] methods =
                    figure.getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(
                        hometask.annotations.DefaultArea.class)) {
                    System.out.println(figure.getSimpleName() + " -> getArea() has @DefaultArea"
                    );
                }
            }
        }
    }
}
