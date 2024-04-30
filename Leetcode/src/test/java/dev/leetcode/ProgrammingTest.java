package dev.leetcode;

import org.javatuples.Pair;
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

    @Test
    @DisplayName("242. Valid Anagram")
    public void testValidAnagram()      {
        List<Triplet<Boolean, String, String>> tests = List.of(
                Triplet.with(true, "anagram", "nagaram"),
                Triplet.with(false, "rat", "car")
        );

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.isAnagram(test.getValue1(), test.getValue2())
        ));
    }

    @Test
    @DisplayName("459. Repeated Substring Pattern")
    public void testRepeatedSubstringPattern()      {
        List<Pair<Boolean, String>> tests = List.of(
                Pair.with(true, "abcabcabcabc"),
                Pair.with(false, "aba"),
                Pair.with(true, "abab")
        );

        tests.forEach(test -> assertEquals(
                        test.getValue0(), problems.repeatedSubstringPattern(test.getValue1())));
    }

    @Test
    @DisplayName("28. Find the Index of the First Occurrence in a String")
    public void testIndexOfFirstOccurrenceString()      {
        List<Triplet<Integer, String, String>> tests = List.of(
                Triplet.with(0, "sadbutsad", "sad"),
                Triplet.with(-1, "leetcode", "leeto")
        );

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.strStr(test.getValue1(), test.getValue2())
        ));
    }

    @Test
    @DisplayName("283. Move Zeroes")
    public void testMoveZeroes()        {
        List<Pair<List<Integer>, List<Integer>>> tests = List.of(
                Pair.with(List.of(1,3,12,0,0), List.of(0,1,0,3,12)),
                Pair.with(List.of(0), List.of(0)),
                Pair.with(List.of(1,3,12,0,0), List.of(1,0,0,3,12)),
                Pair.with(List.of(1,3,12,0,0,0), List.of(1,0,0,3,0,12))
        );

        tests.forEach(test -> assertArrayEquals(
                test.getValue0().stream()
                                .mapToInt(i -> i)
                                .toArray(),
                problems.moveZeroes(
                        test.getValue1().stream()
                                .mapToInt(i -> i)
                                .toArray()
                )
        ));
    }

    @Test
    @DisplayName("66. Plus One")
    public void testPlusOne()   {
        List<Pair<List<Integer>, List<Integer>>> tests = List.of(
                Pair.with(List.of(9,8,7,6,5,4,3,2,1,1), List.of(9,8,7,6,5,4,3,2,1,0)),
                Pair.with(List.of(1,2,4), List.of(1,2,3)),
                Pair.with(List.of(4,3,2,2), List.of(4,3,2,1)),
                Pair.with(List.of(1, 0), List.of(9)),
                Pair.with(List.of(7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,7),
                          List.of(7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6))
        );

        tests.forEach(test ->
                assertArrayEquals(
                        test.getValue0().stream()
                                        .mapToInt(n -> n)
                                        .toArray(),
                        problems.plusOne(test.getValue1().stream()
                                                         .mapToInt(n -> n)
                                                         .toArray())
                ));
    }

    @Test
    @DisplayName("1822. Sign of the Product of an Array")
    public void testArraySign()     {
        List<Pair<Integer, List<Integer>>> tests = List.of(
                Pair.with(1, List.of(-1,-2,-3,-4,3,2,1)),
                Pair.with(0, List.of(1,5,0,2,-3)),
                Pair.with(-1, List.of(-1,1,-1,1,-1)),
                Pair.with(-1, List.of(9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24))
        );

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.arraySign(test.getValue1().stream().mapToInt(n->n).toArray())
        ));
    }

    @Test
    @DisplayName("1502. Can Make Arithmetic Progression From Sequence")
    public void testCanMakeArithmeticProgression()      {
        List<Pair<Boolean, List<Integer>>> tests = List.of(
                Pair.with(true, List.of(3,5,1)),
                Pair.with(false, List.of(1,2,4))
        );

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.canMakeArithmeticProgression(
                                        test.getValue1().stream()
                                                        .mapToInt(n->n)
                                                        .toArray())
        ));
    }

    @Test
    @DisplayName("896. Monotonic Array")
    public void testIsMonotonic()       {
        List<Pair<Boolean, List<Integer>>> tests = List.of(
                Pair.with(true, List.of(1,2,2,3)),
                Pair.with(true, List.of(6,5,4,4)),
                Pair.with(false, List.of(1,3,2)),
                Pair.with(true, List.of(5))
        );

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.isMonotonic(test.getValue1().stream()
                                                    .mapToInt(n->n)
                                                    .toArray())
        ));
    }

    @Test
    @DisplayName("13. Roman to Integer")
    public void testRomanToInt()        {
        List<Pair<Integer, String>> tests = List.of(
                Pair.with(3, "III"),
                Pair.with(58, "LVIII"),
                Pair.with(1994, "MCMXCIV")
        );

        tests.forEach(test -> assertEquals(test.getValue0(), problems.romanToInt(test.getValue1())));
    }

    @Test
    @DisplayName("58. Length of Last Word")
    public void testLengthOfLastWord()      {
        List<Pair<Integer, String>> tests = List.of(
                Pair.with(5, "Hello World"),
                Pair.with(4, "   fly me   to   the moon  "),
                Pair.with(6, "luffy is still joyboy")
        );

        tests.forEach(test -> assertEquals(test.getValue0(), problems.lengthOfLastWord(test.getValue1())));
    }

    @Test
    @DisplayName("709. To Lower Case")
    public void testToLowerCase()   {
        List<Pair<String, String>> tests = List.of(
                Pair.with("hello world", "Hello World"),
                Pair.with("here", "here"),
                Pair.with("lovely", "LOVELY")
        );

        tests.forEach(test -> assertEquals(test.getValue0(), problems.toLowerCase(test.getValue1())));
    }

    @Test
    @DisplayName("682. Baseball Game")
    public void testCalcPoints()    {
        List<Pair<Integer, List<String>>> tests = List.of(
                Pair.with(30, List.of("5","2","C","D","+")),
                Pair.with(27, List.of("5","-2","4","C","D","9","+","+")),
                Pair.with(0, List.of("1","C"))
        );

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.calPoints(test.getValue1().toArray(new String[0]))));
    }

    @Test
    @DisplayName("657. Robot Return to Origin")
    public void testJudgeCircle()       {
        List<Pair<Boolean, String>> tests = List.of(
                Pair.with(true, "UD"),
                Pair.with(false, "LL")
        );

        tests.forEach(test -> assertEquals(test.getValue0(), problems.judgeCircle(test.getValue1())));
    }

    @Test
    @DisplayName("1275. Find Winner on a Tic Tac Toe Game")
    public void testTictacToe()     {
        List<Pair<String, List<List<Integer>>>> tests = List.of(
                Pair.with("A", List.of(
                        List.of(0, 0), List.of(2,0), List.of(1,1), List.of(2,1), List.of(2,2))
                ),
                Pair.with("B", List.of(
                        List.of(0, 0), List.of(1,1), List.of(0,1), List.of(0,2), List.of(1,0), List.of(2, 0))
                ),
                Pair.with("Draw", List.of(
                        List.of(0, 0), List.of(1,1), List.of(0,1), List.of(0,2), List.of(1,0), List.of(2, 0))
                )
        );
    }

    @Test
    @DisplayName("1041. Robot Bounded In Circle")
    public void testIsRobotBounded()    {
        List<Pair<Boolean, String>> tests = List.of(
                Pair.with(true, "GGLLGG"),
                Pair.with(false, "GG"),
                Pair.with(true, "GL")
        );

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.isRobotBounded(test.getValue1())
        ));
    }

    @Test
    @DisplayName("1523. Count Odd Numbers in an Interval Range")
    public void testCountOdds()     {
        List<Triplet<Integer, Integer, Integer>> tests = List.of(
                Triplet.with(3, 3, 7),
                Triplet.with(1, 8, 10)
        );

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.countOdds(test.getValue1(), test.getValue2())));
    }

    @Test
    @DisplayName("1491. Average Salary Excluding the Minimum and Maximum Salary")
    public void testAvgMinMax() {
        List<Pair<Double, List<Integer>>> tests = List.of(
                Pair.with(2500.00000, List.of(4000,3000,1000,2000)),
                Pair.with(2000.00000, List.of(1000,2000,3000))
        );

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.average(test.getValue1().stream()
                                                .mapToInt(n->n)
                                                .toArray())
        ));
    }

    @Test
    @DisplayName("860. Lemonade Change")
    public void testLemonadeChange()    {
        List<Pair<Boolean, List<Integer>>> tests = List.of(
                Pair.with(true, List.of(5,5,5,10,20)),
                Pair.with(false, List.of(5,5,10,10,20))
        );

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.lemonadeChange(test.getValue1().stream()
                                                        .mapToInt(n -> n)
                                                        .toArray())
        ));
    }

    @Test
    @DisplayName("1672. Richest Customer Wealth")
    public void testMaximumWealth()     {
        List<Pair<Integer, List<List<Integer>>>> tests = List.of(
                Pair.with(6, List.of(List.of(1,2,3), List.of(3,2,1))),
                Pair.with(10, List.of(List.of(1,5), List.of(7,3), List.of(3,5))),
                Pair.with(17, List.of(List.of(2,8,7), List.of(7,1,3), List.of(1,9,5)))
        );

//        List<List<Integer>> inp = List.of(List.of(1,2,3), List.of(3,2,1));
//        int[][] array = inp.stream()
//                            .map(row ->
//                                    row.stream()
//                                        .mapToInt(val -> val)
//                                        .toArray())
//                            .toArray(int[][]::new);

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.maximumWealth(
                        test.getValue1().stream()
                                .map(row -> row.stream()
                                               .mapToInt(val -> val)
                                               .toArray())
                                .toArray(int[][]::new))
                ));
    }

    @Test
    @DisplayName("1572. Matrix Diagonal Sum")
    public void testMatrixDiagonalSum()     {
        List<Pair<Integer, List<List<Integer>>>> tests = List.of(
                Pair.with(25,
                        List.of(List.of(1,2,3), List.of(4,5,6), List.of(7, 8, 9))),
                Pair.with(8,
                        List.of(List.of(1, 1, 1, 1), List.of(1, 1, 1, 1), List.of(1, 1, 1, 1), List.of(1, 1, 1, 1))),
                Pair.with(5, List.of(List.of(5)))
        );

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.diagonalSum(
                        test.getValue1().stream()
                                .map(list -> list.stream().mapToInt(n->n).toArray())
                                .toArray(int[][]::new))
        ));
    }

    @Test
    @DisplayName("54. Spiral Matrix")
    public void testSpiralOrder()     {
        List<Pair<List<Integer>, List<List<Integer>>>> tests = List.of(
                Pair.with(List.of(1,2,3,6,9,8,7,4,5),
                        List.of(List.of(1,2,3), List.of(4,5,6), List.of(7, 8, 9))),
                Pair.with(List.of(1,2,3,4,8,12,11,10,9,5,6,7),
                        List.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8), List.of(9, 10, 11, 12)))
        );

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.spiralOrder(
                        test.getValue1().stream()
                                .map(list -> list.stream().mapToInt(n->n).toArray())
                                .toArray(int[][]::new))
        ));
    }

    @Test
    @DisplayName("976. Largest Perimeter Triangle")
    public void testLargestPerimeter()  {
        List<Pair<Integer, List<Integer>>> tests = List.of(
                Pair.with(5, List.of(2, 1, 2)),
                Pair.with(0, List.of(1,2,1,10))
        );

        tests.forEach(test -> assertEquals(
                test.getValue0(),
                problems.largestPerimeter(
                        test.getValue1().stream()
                                        .mapToInt(i->i)
                                        .toArray())
        ));
    }



}
