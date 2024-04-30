package dev.leetcode;

import org.javatuples.Quintet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class Interview150Test {

    Interview150 problems = new Interview150();

    @Test
    @DisplayName("88. Merge Sorted Array")
    public void testMerge() {
        List<Quintet<List<Integer>, List<Integer>, Integer, List<Integer>, Integer>> tests = List.of(
                Quintet.with(
                        List.of(1,2,2,3,5,6),
                        List.of(1,2,3,0,0,0), 3,
                        List.of(2,5,6), 3
                ),
                Quintet.with(
                        List.of(1), List.of(1), 1, List.of(), 0
                ),
                Quintet.with(
                        List.of(1), List.of(0), 0, List.of(1), 1
                )
        );

        tests.forEach(test -> assertEquals(
                test.getValue0().stream()
                                .mapToInt(val -> val)
                                .toArray(),
                problems.merge(
                        test.getValue1().stream()
                                        .mapToInt(val -> val)
                                        .toArray(),
                        test.getValue2(),
                        test.getValue3().stream()
                                        .mapToInt(val -> val)
                                        .toArray(),
                        test.getValue4()
                )
        ));
    }


}
