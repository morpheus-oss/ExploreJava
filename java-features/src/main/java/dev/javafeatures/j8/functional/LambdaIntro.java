package dev.javafeatures.j8.functional;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaIntro {

    Predicate<Boolean> referentialTrue = (object) -> (object == Boolean.TRUE);
    Predicate<Boolean> referentialFalse = (object) -> (object == Boolean.FALSE);

    static Predicate<Integer> isOdd = num -> (num%2) == 1;
    static Predicate<Integer> isEven = num -> (num%2) == 0;

    static Function<Integer, Long> square = (num) -> (long) (num * num);

    long sumOfSquares(List<Integer> listInts, Predicate<Integer> selector)   {

        return listInts.stream().filter(selector)
                                .mapToLong(num -> square.apply(num))
                                .sum();
    }

    String getWordWithHighestLength(String sentence)   {
        return Arrays.stream(sentence.split("")).max(Comparator.comparing(String::length)).get();
    }

    Map<Character, Long> groupingByCharacterCount(String inputString)   {
        if (inputString == null || inputString.isEmpty() || inputString.isBlank())  {
            new HashMap<>();
        }

        return inputString.chars()
                   .mapToObj(chr -> (char) chr)
                   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    boolean areTwoStringsAnagram(String inString1, String inString2)   {

        Map<Character, Long> inMap1 = groupingByCharacterCount(inString1);
        Map<Character, Long> inMap2 = groupingByCharacterCount(inString2);

        return inMap1.equals(inMap2);
    }


    public static void main(String[] args) {
        LambdaIntro intro = new LambdaIntro();
/*
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println("Int List sum of squares:" + intro.sumOfSquares(list, number -> true));
        System.out.println("Int(Even) List sum of squares:" + intro.sumOfSquares(list, isEven));
        System.out.println("Int(Odd) List sum of squares:" + intro.sumOfSquares(list, isOdd));
*/
        String str1 = "Hello, World!";
        String str2 = "Hlloee! Wolrd,";
        System.out.println("Are these strings anagrams: " + intro.areTwoStringsAnagram(null, null));
    }
}
