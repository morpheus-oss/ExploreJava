package dev.leetcode;

import org.javatuples.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ArraysTest {
    ArrayProblems problems = new ArrayProblems();

    @Test
    @DisplayName("1512. Number of Good Pairs")
    public void testWithMixedNumbers() {
        List<Pair<Integer, List<Integer>>> tests = List.of(
                Pair.with(4, List.of(1, 2, 3, 1, 1, 3)),
                Pair.with(6, List.of(1, 1, 1, 1)),      // With same number
                Pair.with(0, List.of(1, 2, 3, 4, 5))    // With distinct numbers
        );

        tests.forEach(test ->
                assertEquals(
                        test.getValue0(),
                        problems.countGoodPairs(
                                test.getValue1().stream()
                                                .mapToInt(Integer::intValue)
                                                .toArray())
                )
        );
    }

    @Test
    @DisplayName("136. Single Number")  // Elements appears 2 times
    public void testSingleNumber()  {
        List<Pair<Integer, List<Integer>>> tests = List.of(
                Pair.with(1, List.of(2, 2, 1)),
                Pair.with(4, List.of(1, 4, 2, 1, 2)),
                Pair.with(1, List.of(1))
        );
        tests.forEach(test ->
                assertEquals(test.getValue0(), problems.singleNumber(
                        test.getValue1().stream()
                                        .mapToInt(i->i)
                                        .toArray())));
    }

    @Test
    @DisplayName("137. Single Number II")  // Elements appear 3 times
    public void testSingleNumber2()  {
        List<Pair<Integer, List<Integer>>> tests = List.of(
                Pair.with(3, List.of(2,2,3,2)),
                Pair.with(99, List.of(0,1,0,1,0,1,99))
        );
        tests.forEach(test ->
                assertEquals(test.getValue0(), problems.singleNumber2(
                        test.getValue1().stream()
                                .mapToInt(i->i)
                                .toArray())));
    }

    @Test
    @DisplayName("137. Single Number III")  // 2 Elements appear only once
    public void testSingleNumber3()  {
        List<Pair<List<Integer>, List<Integer>>> tests = List.of(
                Pair.with(List.of(3,5), List.of(1,2,1,3,2,5)),
                Pair.with(List.of(-1,0), List.of(-1,0)),
                Pair.with(List.of(0,1), List.of(0,1))
        );
        tests.forEach(test ->
                assertArrayEquals(
                        test.getValue0().stream().mapToInt(i->i).toArray(),
                        problems.singleNumber3(
                            test.getValue1().stream()
                                .mapToInt(i->i)
                                .toArray())));
    }

}
