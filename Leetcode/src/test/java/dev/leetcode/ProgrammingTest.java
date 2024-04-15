package dev.leetcode;

import org.javatuples.Triplet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProgrammingTest {

    Programming problems = new Programming();

    @Test
    @DisplayName("389. Find the Difference")
    public void testFindTheDifference()     {
        List<Triplet<Character, String, String>> tests = List.of(
                Triplet.with('e', "abcd", "abcde"),
                Triplet.with('y', "", "y"),
                Triplet.with('a', "a", "aa")
        );

        tests.forEach(test ->
                assertEquals(test.getValue0(),
                        problems.findDifference(test.getValue1(), test.getValue2())));
    }

    @Test
    @DisplayName("1768. Merge Strings Alternately")
    public void testMergeStringsAlternatively()     {
        List<Triplet<String, String, String>> tests = List.of(
                Triplet.with("apbqcr", "abc", "pqr"),
                Triplet.with("apbqrs", "ab", "pqrs"),
                Triplet.with("apbqcd", "abcd", "pq")
        );
        tests.forEach(test ->
                assertEquals(test.getValue0(),
                        problems.mergeStrings(test.getValue1(), test.getValue2())));
    }


}
