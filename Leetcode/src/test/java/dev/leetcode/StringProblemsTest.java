package dev.leetcode;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class StringProblemsTest {

    StringProblems problems = new StringProblems();

    @Test
    @DisplayName("1108. Defanging an IP Address")
    public void testValidIpAddress()    {
        List<Pair<String, String>> testcases = List.of(
                Pair.with("0[.]0[.]0[.]0", "0.0.0.0")
        );

        testcases.forEach(test ->
                Assertions.assertEquals(
                        test.getValue0(),
                        problems.defangIpAddress(test.getValue1())
                )
        );
    }

    @Test
    @DisplayName("2011. Final Value of Variable After Performing Operations")
    public void testFourOperationsMixed()    {
        Map<Integer, List<String>> testcases = Map.of(
                1, List.of("--X","X++","X++"),
                0, List.of("X++","++X","--X","X--"),
                3, List.of("++X","++X","X++")
        );
        testcases.forEach((key, value) -> Assertions.assertEquals(key,
                problems.finalValueAfterOperations(value.toArray(new String[0]))));
    }

    @Test
    @DisplayName("771. Jewels and Stones")
    public void testJewelsExists()  {
        List<Triplet<Integer, String, String>> testCases =
                List.of(
                        Triplet.with(3, "aA", "aAAbbbb"),
                        Triplet.with(0, "z", "ZZ")
                );
        testCases.forEach(t ->
                Assertions.assertEquals(
                        t.getValue(0),
                        problems.numJewelsInStones(t.getValue1(), t.getValue2()))
        );
    }

    @Test
    @DisplayName("2942. Find Words Containing Character")
    public void testAllWordsContainingChar()   {
        List<Triplet<List<Integer>, List<String>, Character>> testcases =
                List.of(
                    Triplet.with(List.of(0, 1), List.of("leet", "code"), 'e'),
                    Triplet.with(List.of(0, 2), List.of("abc","bcd","aaaa","cbc"), 'a'),
                    Triplet.with(List.of(), List.of("abc","bcd","aaaa","cbc"), 'z')
                );

        testcases.forEach(test ->
                Assertions.assertEquals(
                        test.getValue0(),
                        problems.findWordsContaining(
                                test.getValue1().toArray(new String[0]),
                                test.getValue2())));
    }

    @Test
    @DisplayName("1678. Goal Parser Interpretation")
    public void testParseCommand1()     {
        List<Pair<String, String>> testcases = List.of(
                Pair.with("Goal", "G()(al)"),
                Pair.with("Gooooal", "G()()()()(al)"),
                Pair.with("alGalooG", "(al)G(al)()()G")
        );
        testcases.forEach(test ->
                Assertions.assertEquals(test.getValue0(), problems.interpret(test.getValue1()))
        );
    }

    @Test
    @DisplayName("2114. Maximum Number of Words Found in Sentences")
    public void testMaxWordsInSentences1()  {
        List<Pair<Integer, List<String>>> tests = List.of(
                Pair.with(6, List.of("alice and bob love leetcode",
                                "i think so too", "this is great thanks very much")),
                Pair.with(3, List.of("please wait", "continue to fight", "continue to win"))
        );
        tests.forEach(test ->
                Assertions.assertEquals(
                        test.getValue0(),
                        problems.mostWordsFound(test.getValue1().toArray(new String[0]))));
    }


    @Test
    @DisplayName("2828. Check if a String Is an Acronym of Words")
    public void testValidAcronymn1()     {
        List<Triplet<Boolean, List<String>, String>> testcases = List.of(
                Triplet.with(true, List.of("alice","bob","charlie"), "abc"),
                Triplet.with(true, List.of("never","gonna","give","up","on","you"), "ngguoy"),
                Triplet.with(false, List.of("an","apple"), "a")
        );

        testcases.forEach(test ->
                Assertions.assertEquals(
                        test.getValue0(),
                        problems.isAcronymOfWords(
                                test.getValue1().toArray(new String[0]),
                                test.getValue2()
                        )
                )
        );
    }

    @Test
    @DisplayName("2315. Count Asterisks")
    public void testValidCount1()     {
        List<Pair<Integer, String>> testcases = List.of(
                Pair.with(2, "l|*e*et|c**o|*de|")
        );
        testcases.forEach(test ->
                Assertions.assertEquals(
                        test.getValue0(),
                        problems.countAsterisks(test.getValue1())));
    }

    @Test
    @DisplayName("8. String to Integer (atoi)")
    public void testValidString2()  {
        List<Pair<Integer, String>> testcases = List.of(
                Pair.with(-42, "   -42"),
                Pair.with(42, "42"),
                Pair.with(4193, "4193 with words"),
                Pair.with(0, "words and 987")
        );
        testcases.forEach(test ->
                Assertions.assertEquals(test.getValue0(), problems.myAtoi(test.getValue1())));
    }

    @Test
    @DisplayName("10. Regular Expression Matching")
    public void testRegexMatching() {
        List<Triplet<Boolean, String, String>> cases = List.of(
                Triplet.with(false, "aa", "a"),
                Triplet.with(true, "aa", "a*"),
                Triplet.with(true, "ab", ".*"),
                Triplet.with(false, "mississippi", "mis*is*p*.")
        );

        cases.forEach(test -> Assertions.assertEquals(test.getValue0(),
                                            problems.isMatch(test.getValue1(), test.getValue2())));
    }

    @Test
    @DisplayName("67. Add Binary")
    public void testAddBinary()     {
        List<Triplet<String, String, String>> tests = List.of(
                Triplet.with("100", "11", "1"),
                Triplet.with("10101", "1010", "1011")
        );

        tests.forEach(test ->
                Assertions.assertEquals(
                        test.getValue0(),
                        problems.addBinary(test.getValue1(), test.getValue2())));
    }

    @Test
    @DisplayName("49. Group Anagrams")
    public void testGroupAnagrams()     {
        List<Pair<List<List<String>>, List<String>>> tests = List.of(
                Pair.with(
                        List.of(List.of("eat", "tea", "ate"), List.of("bat"), List.of("tan", "nat")),
                        List.of("eat","tea","tan","ate","nat","bat")
                ),
                Pair.with(
                        List.of(List.of()), List.of()
                ),
                Pair.with(
                        List.of(List.of("a")),
                        List.of("a")
                )
        );
        tests.forEach(
                test -> Assertions.assertEquals(
                            test.getValue0(),
                            problems.groupAnagrams(test.getValue1().toArray(new String[0]))
                        )
        );
    }



}
