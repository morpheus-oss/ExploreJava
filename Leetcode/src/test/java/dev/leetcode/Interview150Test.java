package dev.leetcode;

import org.javatuples.Pair;
import org.javatuples.Quintet;
import org.javatuples.Triplet;
import org.javatuples.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class Interview150Test {

  Interview150 problems = new Interview150();

  @Test
  @DisplayName("88. Merge Sorted Array")
  public void testMerge() {
    List<Quintet<List<Integer>, List<Integer>, Integer, List<Integer>, Integer>> tests =
        List.of(
            Quintet.with(
                List.of(1, 2, 2, 3, 5, 6), List.of(1, 2, 3, 0, 0, 0), 3, List.of(2, 5, 6), 3),
            Quintet.with(List.of(1), List.of(1), 1, List.of(), 0),
            Quintet.with(List.of(1), List.of(0), 0, List.of(1), 1));

    tests.forEach(
        test ->
            assertArrayEquals(
                test.getValue0().stream().mapToInt(val -> val).toArray(),
                problems.merge(
                    test.getValue1().stream().mapToInt(val -> val).toArray(),
                    test.getValue2(),
                    test.getValue3().stream().mapToInt(val -> val).toArray(),
                    test.getValue4())));
  }

  @Test
  @DisplayName("27. Remove Element")
  public void testRemoveElement() {
    List<Triplet<Integer, List<Integer>, Integer>> tests =
        List.of(
            Triplet.with(2, List.of(3, 2, 2, 3), 3),
            Triplet.with(5, List.of(0, 1, 2, 2, 3, 0, 4, 2), 2));
    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(),
                problems.removeElement(
                    test.getValue1().stream().mapToInt(val -> val).toArray(), test.getValue2())));
  }

  @Test
  @DisplayName("26. Remove Duplicates from Sorted Array")
  public void testRemoveDuplicates() {
    List<Pair<Integer, List<Integer>>> tests =
        List.of(
            Pair.with(2, List.of(1, 1, 2)), Pair.with(5, List.of(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)));

    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(),
                problems.removeDuplicates(
                    test.getValue1().stream().mapToInt(val -> val).toArray())));
  }

  @Test
  @DisplayName("80. Remove Duplicates from Sorted Array II")
  public void testRemoveDuplicates2() {
      List<Pair<Integer, List<Integer>>> tests =
              List.of(
                      Pair.with(5, List.of(1,1,1,2,2,3)),
                      Pair.with(7, List.of(0,0,1,1,1,1,2,3,3)));

      tests.forEach(
              test ->
                      assertEquals(
                              test.getValue0(),
                              problems.removeDuplicates2(
                                      test.getValue1().stream().mapToInt(val -> val).toArray())));
  }

  @Test
  @DisplayName("169. Majority Element")
  public void testMajorityElement() {
    List<Pair<Integer, List<Integer>>> tests =
        List.of(Pair.with(3, List.of(3, 2, 3)), Pair.with(2, List.of(2, 2, 1, 1, 1, 2, 2)));

    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(),
                problems.majorityElement(
                    test.getValue1().stream().mapToInt(val -> val).toArray())));
  }

  @Test
  @DisplayName("189. Rotate Array")
  public void testRotateArray() {
    List<Triplet<List<Integer>, List<Integer>, Integer>> tests =
        List.of(
            Triplet.with(List.of(5, 6, 7, 1, 2, 3, 4), List.of(1, 2, 3, 4, 5, 6, 7), 3),
            Triplet.with(List.of(3, 99, -1, -100), List.of(-1, -100, 3, 99), 2));

    tests.forEach(
        test ->
            assertArrayEquals(
                test.getValue0().stream().mapToInt(n -> n).toArray(),
                problems.rotate(
                    test.getValue1().stream().mapToInt(n -> n).toArray(), test.getValue2())));
  }

  @Test
  @DisplayName("121. Best Time to Buy and Sell Stock")
  public void testMaxProfit() {
    List<Pair<Integer, List<Integer>>> tests =
        List.of(Pair.with(5, List.of(7, 1, 5, 3, 6, 4)), Pair.with(0, List.of(7, 6, 4, 3, 1)));

    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(),
                problems.maxProfit(test.getValue1().stream().mapToInt(n -> n).toArray())));
  }

  @Test
  @DisplayName("122. Best Time to Buy and Sell Stock II")
  public void testMaxProfit2() {
    List<Pair<Integer, List<Integer>>> tests =
        List.of(
            Pair.with(7, List.of(7, 1, 5, 3, 6, 4)),
            Pair.with(4, List.of(1, 2, 3, 4, 5)),
            Pair.with(0, List.of(7, 6, 4, 3, 1)));

    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(),
                problems.maxProfit2(test.getValue1().stream().mapToInt(n -> n).toArray())));
  }

  @Test
  @DisplayName("55. Jump Game")
  public void testJumpGame() {
    List<Pair<Boolean, List<Integer>>> tests =
        List.of(Pair.with(true, List.of(2, 3, 1, 1, 4)), Pair.with(false, List.of(3, 2, 1, 0, 4)));

    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(),
                problems.canJump(test.getValue1().stream().mapToInt(n -> n).toArray())));
  }

  @Test
  @DisplayName("45. Jump Game II")
  public void testJumpGame2() {
    List<Pair<Integer, List<Integer>>> tests =
        List.of(Pair.with(2, List.of(2, 3, 1, 1, 4)), Pair.with(2, List.of(2, 3, 0, 1, 4)));

    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(),
                problems.jump(test.getValue1().stream().mapToInt(n -> n).toArray())));
  }

  @Test
  @DisplayName("274. H-Index")
  public void testHindex() {
    List<Pair<Integer, List<Integer>>> tests =
        List.of(
            Pair.with(1, List.of(100)),
            Pair.with(0, List.of(0)),
            Pair.with(1, List.of(1, 2)),
            Pair.with(1, List.of(0, 1)),
            Pair.with(3, List.of(3, 0, 6, 1, 5)),
            Pair.with(1, List.of(1, 3, 1)));

    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(),
                problems.hIndex(test.getValue1().stream().mapToInt(n -> n).toArray())));
  }

}
