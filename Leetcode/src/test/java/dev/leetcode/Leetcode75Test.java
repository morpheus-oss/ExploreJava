package dev.leetcode;

import org.javatuples.Triplet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Leetcode75Test {
    Leetcode75 leet = new Leetcode75();

    @Test
    @DisplayName("1071. Greatest Common Divisor of Strings")
    public void testGcdOfStrings()  {
        List<Triplet<String, String, String>> tests = List.of(
                Triplet.with("ABC", "ABCABC", "ABC"),
                Triplet.with("AB", "ABABAB", "ABAB"),
                Triplet.with("", "LEET", "CODE"),
                Triplet.with("", "ABCDEF", "ABC")
        );

        tests.forEach(test ->
                assertEquals(
                        test.getValue0(),
                        leet.gcdOfStrings(test.getValue1(), test.getValue2())
                        ));
    }

    @Test
    @DisplayName("1431. Kids With the Greatest Number of Candies")
    public void testKidsWithCandies()   {
        List<Triplet<List<Boolean>, List<Integer>, Integer>> tests = List.of(
                Triplet.with(
                        List.of(true,true,true,false,true),
                        List.of(2,3,5,1,3),
                        3),
                Triplet.with(
                        List.of(true,false,false,false,false),
                        List.of(4,2,1,1,2),
                        1),
                Triplet.with(
                        List.of(false,true,true),
                        List.of(2,8,7),
                        1),
                Triplet.with(
                        List.of(true,false,true),
                        List.of(12,1,12),
                        10)
        );


    }
}
