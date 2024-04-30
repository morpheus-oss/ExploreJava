package dev.leetcode;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

public class StringProblemsTest {

  StringProblems problems = new StringProblems();

  @Test
  @DisplayName("1108. Defanging an IP Address")
  public void testValidIpAddress() {
    List<Pair<String, String>> testcases = List.of(Pair.with("0[.]0[.]0[.]0", "0.0.0.0"));

    testcases.forEach(
        test -> assertEquals(test.getValue0(), problems.defangIpAddress(test.getValue1())));
  }

  @Test
  @DisplayName("2011. Final Value of Variable After Performing Operations")
  public void testFourOperationsMixed() {
    Map<Integer, List<String>> testcases =
        Map.of(
            1, List.of("--X", "X++", "X++"),
            0, List.of("X++", "++X", "--X", "X--"),
            3, List.of("++X", "++X", "X++"));
    testcases.forEach(
        (key, value) ->
            assertEquals(key, problems.finalValueAfterOperations(value.toArray(new String[0]))));
  }

  @Test
  @DisplayName("771. Jewels and Stones")
  public void testJewelsExists() {
    List<Triplet<Integer, String, String>> testCases =
        List.of(Triplet.with(3, "aA", "aAAbbbb"), Triplet.with(0, "z", "ZZ"));
    testCases.forEach(
        t -> assertEquals(t.getValue(0), problems.numJewelsInStones(t.getValue1(), t.getValue2())));
  }

  @Test
  @DisplayName("2942. Find Words Containing Character")
  public void testAllWordsContainingChar() {
    List<Triplet<List<Integer>, List<String>, Character>> testcases =
        List.of(
            Triplet.with(List.of(0, 1), List.of("leet", "code"), 'e'),
            Triplet.with(List.of(0, 2), List.of("abc", "bcd", "aaaa", "cbc"), 'a'),
            Triplet.with(List.of(), List.of("abc", "bcd", "aaaa", "cbc"), 'z'));

    testcases.forEach(
        test ->
            assertEquals(
                test.getValue0(),
                problems.findWordsContaining(
                    test.getValue1().toArray(new String[0]), test.getValue2())));
  }

  @Test
  @DisplayName("1678. Goal Parser Interpretation")
  public void testParseCommand1() {
    List<Pair<String, String>> testcases =
        List.of(
            Pair.with("Goal", "G()(al)"),
            Pair.with("Gooooal", "G()()()()(al)"),
            Pair.with("alGalooG", "(al)G(al)()()G"));
    testcases.forEach(test -> assertEquals(test.getValue0(), problems.interpret(test.getValue1())));
  }

  @Test
  @DisplayName("2114. Maximum Number of Words Found in Sentences")
  public void testMaxWordsInSentences1() {
    List<Pair<Integer, List<String>>> tests =
        List.of(
            Pair.with(
                6,
                List.of(
                    "alice and bob love leetcode",
                    "i think so too",
                    "this is great thanks very much")),
            Pair.with(3, List.of("please wait", "continue to fight", "continue to win")));
    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(),
                problems.mostWordsFound(test.getValue1().toArray(new String[0]))));
  }

  @Test
  @DisplayName("2828. Check if a String Is an Acronym of Words")
  public void testValidAcronymn1() {
    List<Triplet<Boolean, List<String>, String>> testcases =
        List.of(
            Triplet.with(true, List.of("alice", "bob", "charlie"), "abc"),
            Triplet.with(true, List.of("never", "gonna", "give", "up", "on", "you"), "ngguoy"),
            Triplet.with(false, List.of("an", "apple"), "a"));

    testcases.forEach(
        test ->
            assertEquals(
                test.getValue0(),
                problems.isAcronymOfWords(
                    test.getValue1().toArray(new String[0]), test.getValue2())));
  }

  @Test
  @DisplayName("2315. Count Asterisks")
  public void testValidCount1() {
    List<Pair<Integer, String>> testcases = List.of(Pair.with(2, "l|*e*et|c**o|*de|"));
    testcases.forEach(
        test -> assertEquals(test.getValue0(), problems.countAsterisks(test.getValue1())));
  }

  @Test
  @DisplayName("8. String to Integer (atoi)")
  public void testValidString2() {
    List<Pair<Integer, String>> testcases =
        List.of(
            Pair.with(-42, "   -42"),
            Pair.with(42, "42"),
            Pair.with(4193, "4193 with words"),
            Pair.with(0, "words and 987"));
    testcases.forEach(test -> assertEquals(test.getValue0(), problems.myAtoi(test.getValue1())));
  }

  @Test
  @DisplayName("10. Regular Expression Matching")
  public void testRegexMatching() {
    List<Triplet<Boolean, String, String>> cases =
        List.of(
            Triplet.with(false, "aa", "a"),
            Triplet.with(true, "aa", "a*"),
            Triplet.with(true, "ab", ".*"),
            Triplet.with(false, "mississippi", "mis*is*p*."));

    cases.forEach(
        test ->
            assertEquals(test.getValue0(), problems.isMatch(test.getValue1(), test.getValue2())));
  }

  @Test
  @DisplayName("67. Add Binary")
  public void testAddBinary() {
    List<Triplet<String, String, String>> tests =
        List.of(Triplet.with("100", "11", "1"), Triplet.with("10101", "1010", "1011"));

    tests.forEach(
        test ->
            assertEquals(test.getValue0(), problems.addBinary(test.getValue1(), test.getValue2())));
  }

  @Test
  @DisplayName("49. Group Anagrams")
  public void testGroupAnagrams() {
    List<Pair<List<List<String>>, List<String>>> tests =
        List.of(
            Pair.with(
                List.of(List.of("eat", "tea", "ate"), List.of("bat"), List.of("tan", "nat")),
                List.of("eat", "tea", "tan", "ate", "nat", "bat")),
            Pair.with(List.of(List.of()), List.of()),
            Pair.with(List.of(List.of("a")), List.of("a")));
    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(), problems.groupAnagrams(test.getValue1().toArray(new String[0]))));
  }

  @Test
  @DisplayName("1832. Check if the Sentence Is Pangram")
  public void testCheckIfPangram() {
    List<Pair<Boolean, String>> tests =
        List.of(
            Pair.with(Boolean.TRUE, "thequickbrownfoxjumpsoverthelazydog"),
            Pair.with(Boolean.FALSE, "leetcode"));

    tests.forEach(
        test -> assertEquals(test.getValue0(), problems.checkIfPangram(test.getValue1())));
  }

  @Test
  @DisplayName("2864. Maximum Odd Binary Number")
  public void testMaximumOddBinaryNumber() {
    List<Pair<String, String>> tests = List.of(Pair.with("001", "010"), Pair.with("1001", "0101"));

    tests.forEach(
        test -> assertEquals(test.getValue0(), problems.maximumOddBinaryNumber(test.getValue1())));
  }

  @Test
  @DisplayName("1614. Maximum Nesting Depth of the Parentheses")
  public void testMaxDepth() {
    List<Pair<Integer, String>> tests =
        List.of(Pair.with(3, "(1+(2*3)+((8)/4))+1"), Pair.with(3, "(1)+((2))+(((3)))"));

    tests.forEach(test -> assertEquals(test.getValue0(), problems.maxDepth(test.getValue1())));
  }

  @Test
  @DisplayName("2129. Capitalize the Title")
  public void testCapitalizeTitle() {
    List<Pair<String, String>> tests =
        List.of(
            Pair.with("Capitalize The Title", "capiTalIze tHe titLe"),
            Pair.with("First Letter of Each Word", "First leTTeR of EACH Word"),
            Pair.with("i Love Leetcode", "i lOve leetcode"),
            Pair.with("", ""),
            Pair.with(null, null));

    tests.forEach(
        test -> assertEquals(test.getValue0(), problems.capitalizeTitle(test.getValue1())));
  }

  @Test
  @DisplayName("2325. Decode the Message")
  public void testDecodeMessage() {
    List<Triplet<String, String, String>> tests =
        List.of(
            Triplet.with(
                "the five boxing wizards jump quickly",
                "eljuxhpwnyrdgtqkviszcfmabo",
                "zwx hnfx lqantp mnoeius ycgk vcnjrdb"),
            Triplet.with(
                "this is a secret",
                "the quick brown fox jumps over the lazy dog",
                "vkbs bs t suepuv"));

    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(), problems.decodeMessage(test.getValue1(), test.getValue2())));
  }

  @Test
  @DisplayName("2194. Cells in a Range on an Excel Sheet")
  public void testCellsInRange() {
    List<Pair<List<String>, String>> tests =
        List.of(
            Pair.with(List.of("K1", "K2", "L1", "L2"), "K1:L2"),
            Pair.with(List.of("A1", "B1", "C1", "D1", "E1", "F1"), "A1:F1"));

    tests.forEach(test -> assertEquals(test.getValue0(), problems.cellsInRange(test.getValue1())));
  }

  @Test
  @DisplayName("2108. Find First Palindromic String in the Array")
  public void testFirstPalindrome() {
    List<Pair<String, List<String>>> tests =
        List.of(
            Pair.with("ada", List.of("abc", "car", "ada", "racecar", "cool")),
            Pair.with("racecar", List.of("notapalindrome", "racecar")),
            Pair.with("", List.of("def", "ghi")));

    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(),
                problems.firstPalindrome(test.getValue1().toArray(new String[0]))));
  }

  @Test
  @DisplayName("1816. Truncate Sentence")
  public void testTruncateSentence() {
    List<Triplet<String, String, Integer>> tests =
        List.of(
            Triplet.with("Hello how are you", "Hello how are you Contestant", 4),
            Triplet.with("What is the solution", "What is the solution to this problem", 4),
            Triplet.with("chopper is not a tanuki", "chopper is not a tanuki", 5));

    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(), problems.truncateSentence(test.getValue1(), test.getValue2())));
  }
}
