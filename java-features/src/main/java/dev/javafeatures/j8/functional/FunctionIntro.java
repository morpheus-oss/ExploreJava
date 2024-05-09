package dev.javafeatures.j8.functional;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionIntro {
    private static final double PI = 3.14;

    public static void main(String[] args) {
        Function<Float, Double> square = num -> (double) (num * num);
        System.out.println(square.apply(5f));

        Function<Float, Double> areaOfCircle = radius -> (double) PI * (radius * radius);
        System.out.println(areaOfCircle.apply(7.2f));

        BiFunction<Integer, Integer, Long> intAdder = (a, b) -> (long) (a + b);
        BiFunction<Integer, Integer, Long> intMultiplier = (a, b) -> (long) (a * b);
        Stream.of();
    }
}
