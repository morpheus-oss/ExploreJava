package dev.leetcode;

import java.io.BufferedReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Leetcode problems of 'Strings' category. */
public class StringProblems {
  private static int TOTAL_ALPHABETS = 26;

  enum Result {
    TRUE,
    FALSE
  }

  Result[][] regexMemo;

  /**
   * 1108. Defanging an IP Address Given a valid (IPv4) IP address, return a defanged version of
   * that IP address. A defanged IP address replaces every period "." with "[.]".
   *
   * <p>Example 1: Input: address = "1.1.1.1" Output: "1[.]1[.]1[.]1"
   *
   * <p>Example 2: Input: address = "255.100.50.0" Output: "255[.]100[.]50[.]0"
   *
   * <p>Constraints: The given address is a valid IPv4 address.
   *
   * @param ipAddress
   * @return ipAddress
   *     <p>{@link dev.leetcode.Leetcode75 }
   */
  public String defangIpAddress(String ipAddress) {
    return ipAddress.replace(".", "[.]");
  }

  /**
   * 2011. Final Value of Variable After Performing Operations There is a programming language with
   * only four operations and one variable X:
   *
   * <p>++X and X++ increments the value of the variable X by 1. --X and X-- decrements the value of
   * the variable X by 1. Initially, the value of X is 0.
   *
   * <p>Given an array of strings operations containing a list of operations, return the final value
   * of X after performing all the operations.
   *
   * <p>Example 1: Input: operations = ["--X","X++","X++"] Output: 1 Explanation: The operations are
   * performed as follows: Initially, X = 0. --X: X is decremented by 1, X = 0 - 1 = -1. X++: X is
   * incremented by 1, X = -1 + 1 = 0. X++: X is incremented by 1, X = 0 + 1 = 1.
   *
   * <p>Example 2: Input: operations = ["++X","++X","X++"] Output: 3 Explanation: The operations are
   * performed as follows: Initially, X = 0. ++X: X is incremented by 1, X = 0 + 1 = 1. ++X: X is
   * incremented by 1, X = 1 + 1 = 2. X++: X is incremented by 1, X = 2 + 1 = 3.
   *
   * <p>Example 3: Input: operations = ["X++","++X","--X","X--"] Output: 0 Explanation: The
   * operations are performed as follows: Initially, X = 0. X++: X is incremented by 1, X = 0 + 1 =
   * 1. ++X: X is incremented by 1, X = 1 + 1 = 2. --X: X is decremented by 1, X = 2 - 1 = 1. X--: X
   * is decremented by 1, X = 1 - 1 = 0.
   *
   * <p>Constraints: 1 <= operations.length <= 100 operations[i] will be either "++X", "X++", "--X",
   * or "X--".
   */
  public int finalValueAfterOperations(String[] operations) {

    int variable = 0;
    for (String opn : operations) {
      if (opn.startsWith("++") || opn.endsWith("++")) {
        variable++;
      }
      if (opn.startsWith("--") || opn.endsWith("--")) {
        variable--;
      }
    }
    /*
    for(String o : operations) variable += (44 - o.charAt(1));
     */

    return variable;
  }

  /**
   * 771. Jewels and Stones You're given strings jewels representing the types of stones that are
   * jewels, and stones representing the stones you have. Each character in stones is a type of
   * stone you have. You want to know how many of the stones you have are also jewels. Letters are
   * case sensitive, so "a" is considered a different type of stone from "A".
   *
   * <p>Example 1: Input: jewels = "aA", stones = "aAAbbbb" Output: 3
   *
   * <p>Example 2: Input: jewels = "z", stones = "ZZ" Output: 0
   *
   * <p>Constraints: 1 <= jewels.length, stones.length <= 50 jewels and stones consist of only
   * English letters. All the characters of jewels are unique.
   */
  public int numJewelsInStones(String jewels, String stones) {
    int count = 0;

    for (char ch : stones.toCharArray()) {
      if (jewels.indexOf(ch) != -1) count++;
    }

    return count;
  }

  /**
   * 2942. Find Words Containing Character You are given a 0-indexed array of strings words and a
   * character x. Return an array of indices representing the words that contain the character x.
   * Note that the returned array may be in any order.
   *
   * <p>Example 1: Input: words = ["leet","code"], x = "e" Output: [0,1] Explanation: "e" occurs in
   * both words: "leet", and "code". Hence, we return indices 0 and 1.
   *
   * <p>Example 2: Input: words = ["abc","bcd","aaaa","cbc"], x = "a" Output: [0,2] Explanation: "a"
   * occurs in "abc", and "aaaa". Hence, we return indices 0 and 2.
   *
   * <p>Example 3: Input: words = ["abc","bcd","aaaa","cbc"], x = "z" Output: [] Explanation: "z"
   * does not occur in any of the words. Hence, we return an empty array.
   *
   * <p>Constraints: 1 <= words.length <= 50 1 <= words[i].length <= 50 x is a lowercase English
   * letter. words[i] consists only of lowercase English letters.
   */
  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> indices = new ArrayList<>();

    for (int i = 0; i < words.length; i++) {
      if (words[i].indexOf(x) != -1) {
        indices.add(i);
      }
    }

    return indices;
  }

  /**
   * 1678. Goal Parser Interpretation You own a Goal Parser that can interpret a string command. The
   * command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will
   * interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The
   * interpreted strings are then concatenated in the original order.
   *
   * <p>Given the string command, return the Goal Parser's interpretation of command.
   *
   * <p>Example 1: Input: command = "G()(al)" Output: "Goal" Explanation: The Goal Parser interprets
   * the command as follows: G -> G () -> o (al) -> al The final concatenated result is "Goal".
   *
   * <p>Example 2: Input: command = "G()()()()(al)" Output: "Gooooal"
   *
   * <p>Example 3: Input: command = "(al)G(al)()()G" Output: "alGalooG"
   *
   * <p>Constraints: 1 <= command.length <= 100 command consists of "G", "()", and/or "(al)" in some
   * order.
   */
  public String interpret(String command) {
    StringBuilder builder = new StringBuilder();

    for (int idx = 0; idx < command.length(); ) {
      if (command.charAt(idx) == 'G') {
        builder.append("G");
        idx++;
      } else if (command.charAt(idx) == '(' && command.charAt(idx + 1) == ')') {
        builder.append("o");
        idx += 2;
      } else {
        builder.append("al");
        idx += 4;
      }
    }

    // return command.replace("()", "o").replace("(al)", "al");
    return builder.toString();
  }

  /**
   * 2114. Maximum Number of Words Found in Sentences A sentence is a list of words that are
   * separated by a single space with no leading or trailing spaces. You are given an array of
   * strings sentences, where each sentences[i] represents a single sentence.
   *
   * <p>Return the maximum number of words that appear in a single sentence.
   *
   * <p>Example 1: Input: sentences = ["alice and bob love leetcode", "i think so too", "this is
   * great thanks very much"] Output: 6
   *
   * <p>Explanation: - The first sentence, "alice and bob love leetcode", has 5 words in total. -
   * The second sentence, "i think so too", has 4 words in total. - The third sentence, "this is
   * great thanks very much", has 6 words in total. Thus, the maximum number of words in a single
   * sentence comes from the third sentence, which has 6 words.
   *
   * <p>Example 2: Input: sentences = ["please wait", "continue to fight", "continue to win"]
   * Output: 3
   *
   * <p>Explanation: It is possible that multiple sentences contain the same number of words. In
   * this example, the second and third sentences (underlined) have the same number of words.
   *
   * <p>Constraints: 1 <= sentences.length <= 100 1 <= sentences[i].length <= 100 sentences[i]
   * consists only of lowercase English letters and ' ' only. sentences[i] does not have leading or
   * trailing spaces. All the words in sentences[i] are separated by a single space.
   */
  public int mostWordsFound(String[] sentences) {
    /*
    return Arrays.stream(sentences)
                 .mapToInt(sentence -> sentence.split(" ").length)
                 .max().orElse(-1);
    */
    int max = 0;
    for (String sentence : sentences) {
      max = Math.max(max, wordCount(sentence));
    }
    return max;
  }

  private int wordCount(String sentence) {
    int count = 0;
    for (char ch : sentence.toCharArray()) {
      if (ch == ' ') count++;
    }

    return ++count;
  }

  /**
   * 1221. Split a String in Balanced Strings Balanced strings are those that have an equal quantity
   * of 'L' and 'R' characters.
   *
   * <p>Given a balanced string s, split it into some number of substrings such that:
   *
   * <p>Each substring is balanced. Return the maximum number of balanced strings you can obtain.
   *
   * <p>Example 1: Input: s = "RLRRLLRLRL" Output: 4 Explanation: s can be split into "RL", "RRLL",
   * "RL", "RL", each substring contains same number of 'L' and 'R'.
   *
   * <p>Example 2: Input: s = "RLRRRLLRLL" Output: 2 Explanation: s can be split into "RL",
   * "RRRLLRLL", each substring contains same number of 'L' and 'R'. Note that s cannot be split
   * into "RL", "RR", "RL", "LR", "LL", because the 2nd and 5th substrings are not balanced.
   *
   * <p>Example 3: Input: s = "LLLLRRRR" Output: 1 Explanation: s can be split into "LLLLRRRR".
   *
   * <p>Constraints: 2 <= s.length <= 1000 s[i] is either 'L' or 'R'. s is a balanced string.
   */
  public int balancedStringSplit(String s) {
    int count = 0;
    int rcount = 0;

    for (char ch : s.toCharArray()) {
      if (ch == 'R') {
        rcount++;
      } else {
        rcount--;
      }

      if (rcount == 0) count++;
    }

    return count;
  }

  /**
   * 1662. Check If Two String Arrays are Equivalent Given two string arrays word1 and word2, return
   * true if the two arrays represent the same string, and false otherwise.
   *
   * <p>A string is represented by an array if the array elements concatenated in order forms the
   * string.
   *
   * <p>Example 1: Input: word1 = ["ab", "c"], word2 = ["a", "bc"] Output: true Explanation: word1
   * represents string "ab" + "c" -> "abc" word2 represents string "a" + "bc" -> "abc" The strings
   * are the same, so return true.
   *
   * <p>Example 2: Input: word1 = ["a", "cb"], word2 = ["ab", "c"] Output: false Example 3:
   *
   * <p>Input: word1 = ["abc", "d", "defg"], word2 = ["abcddefg"] Output: true
   *
   * <p>Constraints: 1 <= word1.length, word2.length <= 103 1 <= word1[i].length, word2[i].length <=
   * 103 1 <= sum(word1[i].length), sum(word2[i].length) <= 103 word1[i] and word2[i] consist of
   * lowercase letters.
   */
  public boolean arrayStringsEqual(String[] word1, String[] word2) {
    String w1 = makeAString(word1);
    String w2 = makeAString(word2);

    // String.join("", word1).equals(String.join("", word2));

    return w1.equals(w2);
  }

  private String makeAString(String[] words) {
    StringBuilder builder = new StringBuilder();
    for (String word : words) {
      builder.append(word);
    }
    return builder.toString();
  }

  /**
   * 1773. Count Items Matching a Rule You are given an array items, where each items[i] = [typei,
   * colori, namei] describes the type, color, and name of the ith item. You are also given a rule
   * represented by two strings, ruleKey and ruleValue.
   *
   * <p>The ith item is said to match the rule if one of the following is true:
   *
   * <p>ruleKey == "type" and ruleValue == typei. ruleKey == "color" and ruleValue == colori.
   * ruleKey == "name" and ruleValue == namei. Return the number of items that match the given rule.
   *
   * <p>Example 1: Input: items =
   * [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey =
   * "color", ruleValue = "silver" Output: 1 Explanation: There is only one item matching the given
   * rule, which is ["computer","silver","lenovo"].
   *
   * <p>Example 2: Input: items =
   * [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey =
   * "type", ruleValue = "phone" Output: 2 Explanation: There are only two items matching the given
   * rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item
   * ["computer","silver","phone"] does not match.
   *
   * <p>Constraints: 1 <= items.length <= 104 1 <= typei.length, colori.length, namei.length,
   * ruleValue.length <= 10 ruleKey is equal to either "type", "color", or "name". All strings
   * consist only of lowercase letters.
   */
  public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    int matches = 0;

    for (int idx = 0; idx < items.size(); idx++) {
      // 0 -> type
      if (ruleKey.equals("type") && (items.get(idx).get(0).equals(ruleValue))) matches++;
      // 1 -> color
      if (ruleKey.equals("color") && (items.get(idx).get(1).equals(ruleValue))) matches++;
      // 2 -> name
      if (ruleKey.equals("name") && (items.get(idx).get(2).equals(ruleValue))) matches++;
    }

    return matches;
  }

  /**
   * 1528. Shuffle String You are given a string s and an integer array indices of the same length.
   * The string s will be shuffled such that the character at the ith position moves to indices[i]
   * in the shuffled string.
   *
   * <p>Return the shuffled string.
   *
   * <p>Example 1: Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3] Output: "leetcode"
   * Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
   *
   * <p>Example 2: Input: s = "abc", indices = [0,1,2] Output: "abc" Explanation: After shuffling,
   * each character remains in its position.
   *
   * <p>Constraints: s.length == indices.length == n 1 <= n <= 100 s consists of only lowercase
   * English letters. 0 <= indices[i] < n All values of indices are unique.
   */
  public String restoreString(String s, int[] indices) {
    int length = indices.length;
    char[] out = new char[length];

    for (int i = 0; i < length; i++) {
      out[indices[i]] = s.charAt(i);
    }

    return new String(out);
  }

  /**
   * 1816. Truncate Sentence A sentence is a list of words that are separated by a single space with
   * no leading or trailing spaces. Each of the words consists of only uppercase and lowercase
   * English letters (no punctuation).
   *
   * <p>For example, "Hello World", "HELLO", and "hello world hello world" are all sentences. You
   * are given a sentence s and an integer k. You want to truncate s such that it contains only the
   * first k words. Return s after truncating it.
   *
   * <p>Example 1: Input: s = "Hello how are you Contestant", k = 4 Output: "Hello how are you"
   * Explanation: The words in s are ["Hello", "how" "are", "you", "Contestant"]. The first 4 words
   * are ["Hello", "how", "are", "you"]. Hence, you should return "Hello how are you".
   *
   * <p>Example 2: Input: s = "What is the solution to this problem", k = 4 Output: "What is the
   * solution" Explanation: The words in s are ["What", "is" "the", "solution", "to", "this",
   * "problem"]. The first 4 words are ["What", "is", "the", "solution"]. Hence, you should return
   * "What is the solution".
   *
   * <p>Example 3: Input: s = "chopper is not a tanuki", k = 5 Output: "chopper is not a tanuki"
   *
   * <p>Constraints: 1 <= s.length <= 500 k is in the range [1, the number of words in s]. s consist
   * of only lowercase and uppercase English letters and spaces. The words in s are separated by a
   * single space. There are no leading or trailing spaces.
   */
  public String truncateSentence(String s, int k) {
    int idx = 0;
    for (; idx < s.length(); idx++) {
      if (s.charAt(idx) == ' ') {
        k--;
      }
      if (k == 0) break;
    }

    return s.substring(0, idx);
  }

  /**
   * 2108. Find First Palindromic String in the Array
   *
   * <p>Given an array of strings words, return the first palindromic string in the array. If there
   * is no such string, return an empty string "".
   *
   * <p>A string is palindromic if it reads the same forward and backward.
   *
   * <p>Example 1: Input: words = ["abc","car","ada","racecar","cool"] Output: "ada" Explanation:
   * The first string that is palindromic is "ada". Note that "racecar" is also palindromic, but it
   * is not the first.
   *
   * <p>Example 2: Input: words = ["notapalindrome","racecar"] Output: "racecar" Explanation: The
   * first and only string that is palindromic is "racecar".
   *
   * <p>Example 3: Input: words = ["def","ghi"] Output: "" Explanation: There are no palindromic
   * strings, so the empty string is returned.
   *
   * <p>Constraints: 1 <= words.length <= 100 1 <= words[i].length <= 100 words[i] consists only of
   * lowercase English letters.
   */
  public String firstPalindrome(String[] words) {
    return Arrays.stream(words).filter(this::isPalindrome).findFirst().orElse("");
  }

  private boolean isPalindrome(String word) {
    int left = 0;
    int right = word.length() - 1;

    while (left < right) {
      if (word.charAt(left++) != word.charAt(right--)) {
        return false;
      }
    }
    return true;
  }

  /**
   * 2194. Cells in a Range on an Excel Sheet
   *
   * <p>A cell (r, c) of an excel sheet is represented as a string "<col><row>" where:
   *
   * <p><col> denotes the column number c of the cell. It is represented by alphabetical letters.
   * For example, the 1st column is denoted by 'A', the 2nd by 'B', the 3rd by 'C', and so on. <row>
   * is the row number r of the cell. The rth row is represented by the integer r. You are given a
   * string s in the format "<col1><row1>:<col2><row2>", where <col1> represents the column c1,
   * <row1> represents the row r1, <col2> represents the column c2, and <row2> represents the row
   * r2, such that r1 <= r2 and c1 <= c2.
   *
   * <p>Return the list of cells (x, y) such that r1 <= x <= r2 and c1 <= y <= c2. The cells should
   * be represented as strings in the format mentioned above and be sorted in non-decreasing order
   * first by columns and then by rows.
   *
   * <p>Example 1: Input: s = "K1:L2" Output: ["K1","K2","L1","L2"] Explanation: The above diagram
   * shows the cells which should be present in the list. The red arrows denote the order in which
   * the cells should be presented.
   *
   * <p>Example 2: Input: s = "A1:F1" Output: ["A1","B1","C1","D1","E1","F1"] Explanation: The above
   * diagram shows the cells which should be present in the list. The red arrow denotes the order in
   * which the cells should be presented.
   *
   * <p>Constraints: s.length == 5 'A' <= s[0] <= s[3] <= 'Z' '1' <= s[1] <= s[4] <= '9' s consists
   * of uppercase English letters, digits and ':'.
   */
  public List<String> cellsInRange(String s) {
    List<String> list = new ArrayList<>();

    for (char i = s.charAt(0); i <= s.charAt(3); i++) {
      for (char j = s.charAt(1); j <= s.charAt(4); j++) {
        list.add("" + i + j);
      }
    }

    return list;
  }

  /**
   * 2325. Decode the Message You are given the strings key and message, which represent a cipher
   * key and a secret message, respectively. The steps to decode message are as follows:
   *
   * <p>Use the first appearance of all 26 lowercase English letters in key as the order of the
   * substitution table.
   *
   * <p>Align the substitution table with the regular English alphabet. Each letter in message is
   * then substituted using the table. Spaces ' ' are transformed to themselves. For example, given
   * key = "happy boy" (actual key would have at least one instance of each letter in the alphabet),
   * we have the partial substitution table of ('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b'
   * -> 'e', 'o' -> 'f').
   *
   * <p>Return the decoded message.
   *
   * <p>Example 1: Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t
   * suepuv" Output: "this is a secret" Explanation: The diagram above shows the substitution table.
   * It is obtained by taking the first appearance of each letter in "the quick brown fox jumps over
   * the lazy dog".
   *
   * <p>Example 2: Input: key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius
   * ycgk vcnjrdb" Output: "the five boxing wizards jump quickly" Explanation: The diagram above
   * shows the substitution table. It is obtained by taking the first appearance of each letter in
   * "eljuxhpwnyrdgtqkviszcfmabo".
   *
   * <p>Constraints: 26 <= key.length <= 2000 key consists of lowercase English letters and ' '. key
   * contains every letter in the English alphabet ('a' to 'z') at least once. 1 <= message.length
   * <= 2000 message consists of lowercase English letters and ' '.
   */
  public String decodeMessage(String key, String message) {
    char[] hashes = new char[128];
    hashes[32] = 32;
    char ch = 'a';
    for (char c : key.toCharArray()) {
      char hash = hashes[c];
      if (hash == 0) {
        hashes[c] = ch++;
      }
    }
    char[] result = new char[message.length()];
    for (int j = 0; j < message.length(); j++) {
      result[j] = hashes[message.charAt(j)];
    }
    return new String(result);
  }

  /**
   * 2129. Capitalize the Title You are given a string title consisting of one or more words
   * separated by a single space, where each word consists of English letters. Capitalize the string
   * by changing the capitalization of each word such that:
   *
   * <p>If the length of the word is 1 or 2 letters, change all letters to lowercase. Otherwise,
   * change the first letter to uppercase and the remaining letters to lowercase. Return the
   * capitalized title.
   *
   * <p>Example 1: Input: title = "capiTalIze tHe titLe" Output: "Capitalize The Title" Explanation:
   * Since all the words have a length of at least 3, the first letter of each word is uppercase,
   * and the remaining letters are lowercase.
   *
   * <p>Example 2: Input: title = "First leTTeR of EACH Word" Output: "First Letter of Each Word"
   * Explanation: The word "of" has length 2, so it is all lowercase. The remaining words have a
   * length of at least 3, so the first letter of each remaining word is uppercase, and the
   * remaining letters are lowercase.
   *
   * <p>Example 3: Input: title = "i lOve leetcode" Output: "i Love Leetcode" Explanation: The word
   * "i" has length 1, so it is lowercase. The remaining words have a length of at least 3, so the
   * first letter of each remaining word is uppercase, and the remaining letters are lowercase.
   *
   * <p>Constraints: 1 <= title.length <= 100 title consists of words separated by a single space
   * without any leading or trailing spaces. Each word consists of uppercase and lowercase English
   * letters and is non-empty.
   */
  public String capitalizeTitle(String title) {
    if (title == null || title.isEmpty()) {
      return title;
    }

    return Arrays.stream(title.split(" "))
        .map(
            word ->
                (word.length() <= 2)
                    ? word.toLowerCase()
                    : Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
        .collect(Collectors.joining(" "));
  }

  /**
   * 1614. Maximum Nesting Depth of the Parentheses A string is a valid parentheses string (denoted
   * VPS) if it meets one of the following:
   *
   * <p>It is an empty string "", or a single character not equal to "(" or ")", It can be written
   * as AB (A concatenated with B), where A and B are VPS's, or It can be written as (A), where A is
   * a VPS. We can similarly define the nesting depth depth(S) of any VPS S as follows:
   *
   * <p>depth("") = 0 depth(C) = 0, where C is a string with a single character not equal to "(" or
   * ")". depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's. depth("(" + A + ")") = 1
   * + depth(A), where A is a VPS. For example, "", "()()", and "()(()())" are VPS's (with nesting
   * depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
   *
   * <p>Given a VPS represented as string s, return the nesting depth of s.
   *
   * <p>Example 1: Input: s = "(1+(2*3)+((8)/4))+1" Output: 3 Explanation: Digit 8 is inside of 3
   * nested parentheses in the string.
   *
   * <p>Example 2: Input: s = "(1)+((2))+(((3)))" Output: 3
   *
   * <p>Constraints: 1 <= s.length <= 100 s consists of digits 0-9 and characters '+', '-', '*',
   * '/', '(', and ')'. It is guaranteed that parentheses expression s is a VPS.
   */
  public int maxDepth(String s) {
    int depth = 0, maxDepth = 0;

    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        depth++;
      } else if (ch == ')') {
        depth--;
      }
      maxDepth = Math.max(depth, maxDepth);
    }

    return maxDepth;
  }

  /**
   * 2864. Maximum Odd Binary Number You are given a binary string s that contains at least one '1'.
   *
   * <p>You have to rearrange the bits in such a way that the resulting binary number is the maximum
   * odd binary number that can be created from this combination.
   *
   * <p>Return a string representing the maximum odd binary number that can be created from the
   * given combination.
   *
   * <p>Note: that the resulting string can have leading zeros.
   *
   * <p>Example 1: Input: s = "010" Output: "001" Explanation: Because there is just one '1', it
   * must be in the last position. So the answer is "001".
   *
   * <p>Example 2: Input: s = "0101" Output: "1001" Explanation: One of the '1's must be in the last
   * position. The maximum number that can be made with the remaining digits is "100". So the answer
   * is "1001".
   *
   * <p>Constraints: 1 <= s.length <= 100 s consists only of '0' and '1'. s contains at least one
   * '1'.
   */
  public String maximumOddBinaryNumber(String s) {
    int count0 = 0, count1 = 0;

    for (char ch : s.toCharArray()) {
      if (ch == '0') count0++;
      else if (ch == '1') count1++;
    }

    return "1".repeat(count1 - 1) + "0".repeat(count0) + "1";
  }

  /**
   * 1832. Check if the Sentence Is Pangram A pangram is a sentence where every letter of the
   * English alphabet appears at least once.
   *
   * <p>Given a string sentence containing only lowercase English letters, return true if sentence
   * is a pangram, or false otherwise.
   *
   * <p>Example 1: Input: sentence = "thequickbrownfoxjumpsoverthelazydog" Output: true Explanation:
   * sentence contains at least one of every letter of the English alphabet.
   *
   * <p>Example 2: Input: sentence = "leetcode" Output: false
   *
   * <p>Constraints: 1 <= sentence.length <= 1000 sentence consists of lowercase English letters.
   */
  public boolean checkIfPangram(String sentence) {
    /*
    Set<Character> set = sentence.chars().mapToObj(ch -> (char) ch)
                                         .collect(Collectors.toSet());
    return (set.size() == TOTAL_ALPHABETS);
    */
    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (sentence.indexOf(ch) == -1) {
        return false;
      }
    }

    return true;
  }

  /**
   * 557. Reverse Words in a String III Given a string s, reverse the order of characters in each
   * word within a sentence while still preserving whitespace and initial word order.
   *
   * <p>Example 1: Input: s = "Let's take LeetCode contest" Output: "s'teL ekat edoCteeL tsetnoc"
   *
   * <p>Example 2: Input: s = "Mr Ding" Output: "rM gniD"
   *
   * <p>Constraints: 1 <= s.length <= 5 * 104 s contains printable ASCII characters. s does not
   * contain any leading or trailing spaces. There is at least one word in s. All the words in s are
   * separated by a single space.
   */
  public String reverseWords(String s) {

    return Arrays.stream(s.split(" ")).map(this::reverseString).collect(Collectors.joining(" "));
    /*
    StringBuilder builder = new StringBuilder();
    for (String word : s.split(" "))    {
        builder.append(reverseString(word)).append(" ");
    }
    return builder.toString().trim();
    */
  }

  private String reverseString(String word) {
    char[] str = new char[word.length()];
    int idx = 0;
    for (int ch = word.length() - 1; ch >= 0; ch--) {
      str[idx++] = word.charAt(ch);
    }
    return new String(str);
  }

  /**
   * 1684. Count the Number of Consistent Strings You are given a string allowed consisting of
   * distinct characters and an array of strings words. A string is consistent if all characters in
   * the string appear in the string allowed.
   *
   * <p>Return the number of consistent strings in the array words.
   *
   * <p>Example 1: Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"] Output: 2
   * Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and
   * 'b'.
   *
   * <p>Example 2: Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"] Output: 7
   * Explanation: All strings are consistent.
   *
   * <p>Example 3: Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
   * Output: 4 Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
   *
   * <p>Constraints: 1 <= words.length <= 104 1 <= allowed.length <= 26 1 <= words[i].length <= 10
   * The characters in allowed are distinct. words[i] and allowed contain only lowercase English
   * letters.
   */
  public int countConsistentStrings(String allowed, String[] words) {
    int count = words.length;
    int[] store = new int[26];

    for (char c : allowed.toCharArray()) {
      store[c - 'a']++;
    }

    for (String word : words) {

      for (char c : word.toCharArray()) {
        if (store[c - 'a'] <= 0) {
          count--;
          break;
        }
      }
    }
    return count;
  }

  /**
   * 1859. Sorting the Sentence A sentence is a list of words that are separated by a single space
   * with no leading or trailing spaces. Each word consists of lowercase and uppercase English
   * letters.
   *
   * <p>A sentence can be shuffled by appending the 1-indexed word position to each word then
   * rearranging the words in the sentence.
   *
   * <p>For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1"
   * or "is2 sentence4 This1 a3". Given a shuffled sentence s containing no more than 9 words,
   * reconstruct and return the original sentence.
   *
   * <p>Example 1: Input: s = "is2 sentence4 This1 a3" Output: "This is a sentence" Explanation:
   * Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the
   * numbers.
   *
   * <p>Example 2: Input: s = "Myself2 Me1 I4 and3" Output: "Me Myself and I" Explanation: Sort the
   * words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.
   *
   * <p>Constraints: 2 <= s.length <= 200 s consists of lowercase and uppercase English letters,
   * spaces, and digits from 1 to 9. The number of words in s is between 1 and 9. The words in s are
   * separated by a single space. s contains no leading or trailing spaces.
   */
  public String sortSentence(String s) {
    String[] words = s.split(" ");
    String[] out = new String[words.length];

    for (String word : words) {
      int idx = Character.getNumericValue(word.charAt(word.length() - 1)) - 1;
      out[idx] = word.substring(0, word.length() - 1);
    }

    return String.join(" ", out);
  }

  /**
   * 2810. Faulty Keyboard Your laptop keyboard is faulty, and whenever you type a character 'i' on
   * it, it reverses the string that you have written. Typing other characters works as expected.
   *
   * <p>You are given a 0-indexed string s, and you type each character of s using your faulty
   * keyboard.
   *
   * <p>Return the final string that will be present on your laptop screen.
   *
   * <p>Example 1: Input: s = "string" Output: "rtsng" Explanation: After typing first character,
   * the text on the screen is "s". After the second character, the text is "st". After the third
   * character, the text is "str". Since the fourth character is an 'i', the text gets reversed and
   * becomes "rts". After the fifth character, the text is "rtsn". After the sixth character, the
   * text is "rtsng". Therefore, we return "rtsng".
   *
   * <p>Example 2: Input: s = "poiinter" Output: "ponter" Explanation: After the first character,
   * the text on the screen is "p". After the second character, the text is "po". Since the third
   * character you type is an 'i', the text gets reversed and becomes "op". Since the fourth
   * character you type is an 'i', the text gets reversed and becomes "po". After the fifth
   * character, the text is "pon". After the sixth character, the text is "pont". After the seventh
   * character, the text is "ponte". After the eighth character, the text is "ponter". Therefore, we
   * return "ponter".
   *
   * <p>Constraints: 1 <= s.length <= 100 s consists of lowercase English letters. s[0] != 'i'
   */
  public String faultyKeyboard(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'i') {
        count++;
      }
    }
    String out = null;
    boolean odd = (count % 2 == 1);
    if (odd) {
      int idx = s.lastIndexOf('i');
      String rev = reverseString(s.substring(0, idx));
      out = rev.concat(s.substring(idx));
    } else {
      out = s;
    }

    return out.replace("i", "");
  }

  /**
   * 2828. Check if a String Is an Acronym of Words Given an array of strings words and a string s,
   * determine if s is an acronym of words.
   *
   * <p>The string s is considered an acronym of words if it can be formed by concatenating the
   * first character of each string in words in order. For example, "ab" can be formed from
   * ["apple", "banana"], but it can't be formed from ["bear", "aardvark"].
   *
   * <p>Return true if s is an acronym of words, and false otherwise.
   *
   * <p>Example 1: Input: words = ["alice","bob","charlie"], s = "abc" Output: true Explanation: The
   * first character in the words "alice", "bob", and "charlie" are 'a', 'b', and 'c', respectively.
   * Hence, s = "abc" is the acronym.
   *
   * <p>Example 2: Input: words = ["an","apple"], s = "a" Output: false Explanation: The first
   * character in the words "an" and "apple" are 'a' and 'a', respectively. The acronym formed by
   * concatenating these characters is "aa". Hence, s = "a" is not the acronym.
   *
   * <p>Example 3: Input: words = ["never","gonna","give","up","on","you"], s = "ngguoy" Output:
   * true Explanation: By concatenating the first character of the words in the array, we get the
   * string "ngguoy". Hence, s = "ngguoy" is the acronym.
   *
   * <p>Constraints: 1 <= words.length <= 100 1 <= words[i].length <= 10 1 <= s.length <= 100
   * words[i] and s consist of lowercase English letters.
   */
  public boolean isAcronymOfWords(String[] words, String s) {
    if (words == null || s == null) return false;
    if (words.length != s.length()) return false;

    for (int i = 0; i < words.length; i++) {
      if (words[i].charAt(0) != s.charAt(i)) {
        return false;
      }
    }

    return true;
  }

  /**
   * 804. Unique Morse Code Words International Morse Code defines a standard encoding where each
   * letter is mapped to a series of dots and dashes, as follows:
   *
   * <p>'a' maps to ".-", 'b' maps to "-...", 'c' maps to "-.-.", and so on. For convenience, the
   * full table for the 26 letters of the English alphabet is given below:
   *
   * <p>[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
   * ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."] Given an array of
   * strings words where each word can be written as a concatenation of the Morse code of each
   * letter.
   *
   * <p>For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.",
   * ".-", and "-...". We will call such a concatenation the transformation of a word. Return the
   * number of different transformations among all words we have.
   *
   * <p>Example 1: Input: words = ["gin","zen","gig","msg"] Output: 2 Explanation: The
   * transformation of each word is: "gin" -> "--...-." "zen" -> "--...-." "gig" -> "--...--." "msg"
   * -> "--...--." There are 2 different transformations: "--...-." and "--...--.".
   *
   * <p>Example 2: Input: words = ["a"] Output: 1
   *
   * <p>Constraints: 1 <= words.length <= 100 1 <= words[i].length <= 12 words[i] consists of
   * lowercase English letters.
   */
  public int uniqueMorseRepresentations(String[] words) {
    String[] morse =
        new String[] {
          ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
          "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
          "-.--", "--.."
        };
    Set<String> result = new HashSet<>();

    for (String word : words) {
      StringBuilder builder = new StringBuilder();
      for (char ch : word.toCharArray()) {
        builder.append(morse[ch - 'a']);
      }
      result.add(builder.toString());
    }

    return result.size();
  }

  /**
   * 1021. Remove Outermost Parentheses A valid parentheses string is either empty "", "(" + A +
   * ")", or A + B, where A and B are valid parentheses strings, and + represents string
   * concatenation.
   *
   * <p>For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings. A valid
   * parentheses string s is primitive if it is nonempty, and there does not exist a way to split it
   * into s = A + B, with A and B nonempty valid parentheses strings.
   *
   * <p>Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ...
   * + Pk, where Pi are primitive valid parentheses strings.
   *
   * <p>Return s after removing the outermost parentheses of every primitive string in the primitive
   * decomposition of s.
   *
   * <p>Example 1: Input: s = "(()())(())" Output: "()()()" Explanation: The input string is
   * "(()())(())", with primitive decomposition "(()())" + "(())". After removing outer parentheses
   * of each part, this is "()()" + "()" = "()()()".
   *
   * <p>Example 2: Input: s = "(()())(())(()(()))" Output: "()()()()(())" Explanation: The input
   * string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
   * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" =
   * "()()()()(())".
   *
   * <p>Example 3: Input: s = "()()" Output: "" Explanation: The input string is "()()", with
   * primitive decomposition "()" + "()". After removing outer parentheses of each part, this is ""
   * + "" = "".
   *
   * <p>Constraints: 1 <= s.length <= 105 s[i] is either '(' or ')'. s is a valid parentheses
   * string.
   */
  public String removeOuterParentheses(String s) {
    if (s == null || s.length() <= 2) return "";

    StringBuilder builder = new StringBuilder();
    int open = 0;

    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        if (open++ > 0) builder.append("(");
      } else {
        if (open-- > 1) builder.append(")");
      }
    }

    return builder.toString();
  }

  /**
   * 2710. Remove Trailing Zeros From a String Given a positive integer num represented as a string,
   * return the integer num without trailing zeros as a string.
   *
   * <p>Example 1: Input: num = "51230100" Output: "512301" Explanation: Integer "51230100" has 2
   * trailing zeros, we remove them and return integer "512301".
   *
   * <p>Example 2: Input: num = "123" Output: "123" Explanation: Integer "123" has no trailing
   * zeros, we return integer "123".
   *
   * <p>Constraints: 1 <= num.length <= 1000 num consists of only digits. num doesn't have any
   * leading zeros.
   */
  public String removeTrailingZeros(String num) {
    int idx = 0;
    for (idx = num.length() - 1; idx >= 0; idx--) {
      if (num.charAt(idx) != '0') break;
    }
    return num.substring(0, idx + 1);
  }

  /**
   * 1309. Decrypt String from Alphabet to Integer Mapping You are given a string s formed by digits
   * and '#'. We want to map s to English lowercase characters as follows:
   *
   * <p>Characters ('a' to 'i') are represented by ('1' to '9') respectively. Characters ('j' to
   * 'z') are represented by ('10#' to '26#') respectively. Return the string formed after mapping.
   *
   * <p>The test cases are generated so that a unique mapping will always exist.
   *
   * <p>Example 1: Input: s = "10#11#12" Output: "jkab" Explanation: "j" -> "10#" , "k" -> "11#" ,
   * "a" -> "1" , "b" -> "2".
   *
   * <p>Example 2: Input: s = "1326#" Output: "acz"
   *
   * <p>Constraints: 1 <= s.length <= 1000 s consists of digits and the '#' letter. s will be a
   * valid string such that mapping is always possible.
   */
  public String freqAlphabets(String s) {
    StringBuilder builder = new StringBuilder();

    for (int i = s.length() - 1; i >= 0; i--) {
      int num;
      if (s.charAt(i) == '#') {
        num = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
        i -= 2;
      } else {
        num = s.charAt(i) - '0';
      }
      builder.append((char) (num + 96));
    }

    return builder.reverse().toString();
  }

  /**
   * 2103. Rings and Rods There are n rings and each ring is either red, green, or blue. The rings
   * are distributed across ten rods labeled from 0 to 9.
   *
   * <p>You are given a string rings of length 2n that describes the n rings that are placed onto
   * the rods. Every two characters in rings forms a color-position pair that is used to describe
   * each ring where:
   *
   * <p>The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B'). The second
   * character of the ith pair denotes the rod that the ith ring is placed on ('0' to '9'). For
   * example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod labeled 3, a green
   * ring placed onto the rod labeled 2, and a blue ring placed onto the rod labeled 1.
   *
   * <p>Return the number of rods that have all three colors of rings on them.
   *
   * <p>Example 1: Input: rings = "B0B6G0R6R0R6G9" Output: 1 Explanation: - The rod labeled 0 holds
   * 3 rings with all colors: red, green, and blue. - The rod labeled 6 holds 3 rings, but it only
   * has red and blue. - The rod labeled 9 holds only a green ring. Thus, the number of rods with
   * all three colors is 1.
   *
   * <p>Example 2: Input: rings = "B0R0G0R9R0B0G0" Output: 1 Explanation: - The rod labeled 0 holds
   * 6 rings with all colors: red, green, and blue. - The rod labeled 9 holds only a red ring. Thus,
   * the number of rods with all three colors is 1.
   *
   * <p>Example 3: Input: rings = "G4" Output: 0 Explanation: Only one ring is given. Thus, no rods
   * have all three colors.
   *
   * <p>Constraints: rings.length == 2 * n 1 <= n <= 100 rings[i] where i is even is either 'R',
   * 'G', or 'B' (0-indexed). rings[i] where i is odd is a digit from '0' to '9' (0-indexed).
   *
   * @param rings
   * @return int
   */
  public int countPoints(String rings) {
    /* Another Approach
        int r[] = new int[10];
    int g[] = new int[10];
    int b[] = new int[10];

    int n = rings.length();

    for(int i=0; i<n; i+=2){

        //convert char to integer
        int a = rings.charAt(i+1)-'0';

        //System.out.println(rings.charAt(i) + " " + rings.charAt(i+1));

        //wherever rings are present add it in that colour array
        if(rings.charAt(i) == 'R'){
            r[a]++;
        }
        else if(rings.charAt(i) == 'G'){
            g[a]++;
        }
        else if(rings.charAt(i) == 'B'){
            b[a]++;
        }
    }

    //if all three rings are present increase count
    int count=0;
    for(int j=0; j<10; j++){
        if(r[j] > 0 && g[j] > 0 && b[j] > 0)
            count++;
    }

    return count;
         */
    Set<Integer> r = new HashSet<>(), g = new HashSet<>(), b = new HashSet<>();
    for (int i = 0; i < rings.length(); i += 2) {
      if (rings.charAt(i) == 'R') r.add(rings.charAt(i + 1) - '0');
      else if (rings.charAt(i) == 'B') b.add(rings.charAt(i + 1) - '0');
      else g.add(rings.charAt(i + 1) - '0');
    }
    int ans = 0;
    for (int i = 0; i <= 9; i++) {
      if (r.contains(i) && g.contains(i) && b.contains(i)) ans++;
    }
    return ans;
  }

  /**
   * 2000. Reverse Prefix of Word Given a 0-indexed string word and a character ch, reverse the
   * segment of word that starts at index 0 and ends at the index of the first occurrence of ch
   * (inclusive). If the character ch does not exist in word, do nothing.
   *
   * <p>For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that
   * starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd". Return the
   * resulting string.
   *
   * <p>Example 1: Input: word = "abcdefd", ch = "d" Output: "dcbaefd" Explanation: The first
   * occurrence of "d" is at index 3. Reverse the part of word from 0 to 3 (inclusive), the
   * resulting string is "dcbaefd".
   *
   * <p>Example 2: Input: word = "xyxzxe", ch = "z" Output: "zxyxxe" Explanation: The first and only
   * occurrence of "z" is at index 3. Reverse the part of word from 0 to 3 (inclusive), the
   * resulting string is "zxyxxe".
   *
   * <p>Example 3: Input: word = "abcd", ch = "z" Output: "abcd" Explanation: "z" does not exist in
   * word. You should not do any reverse operation, the resulting string is "abcd".
   *
   * <p>Constraints: 1 <= word.length <= 250 word consists of lowercase English letters. ch is a
   * lowercase English letter.
   *
   * @param word
   * @param ch
   * @return String
   */
  public String reversePrefix(String word, char ch) {
    if (word == null || word.isEmpty()) return word;

    int idx = word.indexOf(ch);
    if (idx < 0) return word;
    String rev = reverseString(word.substring(0, idx + 1));

    return rev.concat(word.substring(idx + 1));
  }

  /**
   * 2264. Largest 3-Same-Digit Number in String You are given a string num representing a large
   * integer. An integer is good if it meets the following conditions: It is a substring of num with
   * length 3. It consists of only one unique digit. Return the maximum good integer as a string or
   * an empty string "" if no such integer exists. Note: A substring is a contiguous sequence of
   * characters within a string. There may be leading zeroes in num or a good integer.
   *
   * <p>Example 1: Input: num = "6777133339" Output: "777" Explanation: There are two distinct good
   * integers: "777" and "333". "777" is the largest, so we return "777".
   *
   * <p>Example 2: Input: num = "2300019" Output: "000" Explanation: "000" is the only good integer.
   *
   * <p>Example 3: Input: num = "42352338" Output: "" Explanation: No substring of length 3 consists
   * of only one unique digit. Therefore, there are no good integers.
   *
   * <p>Constraints: 3 <= num.length <= 1000 num only consists of digits.
   *
   * @param num
   * @return String
   */
  public String largestGoodInteger(String num) {
    /*
    String[] nums = {"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};
    for (String e : nums) {
        if (num.contains(e))
            return e;
    }
    return "";
     */
    int n = -1;
    String out = "";

    for (int i = 0; i + 2 < num.length(); i++) {
      if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
        int temp = Character.getNumericValue(num.charAt(i));
        if (temp > n) {
          n = temp;
          out = num.substring(i, i + 3);
        }
      }
    }
    return out;
  }

  /**
   * 1941. Check if All Characters Have Equal Number of Occurrences Given a string s, return true if
   * s is a good string, or false otherwise.
   *
   * <p>A string s is good if all the characters that appear in s have the same number of
   * occurrences (i.e., the same frequency).
   *
   * <p>Example 1: Input: s = "abacbc" Output: true Explanation: The characters that appear in s are
   * 'a', 'b', and 'c'. All characters occur 2 times in s.
   *
   * <p>Example 2: Input: s = "aaabb" Output: false Explanation: The characters that appear in s are
   * 'a' and 'b'. 'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of
   * times.
   *
   * <p>Constraints: 1 <= s.length <= 1000 s consists of lowercase English letters.
   *
   * @param s
   * @return boolean
   */
  public boolean areOccurrencesEqual(String s) {
    /*
    int[] freq = new int[26];

    for(char c: s.toCharArray()){
        freq[c - 'a']++;
    }

    int prev = freq[s.charAt(0) - 'a'];

    for(int num: freq){
        if(num != 0 && num != prev){
            return false;
        }
    }
    return true;
     */
    Map<Character, Long> map =
        s.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    long count = -1;
    for (Map.Entry<Character, Long> entry : map.entrySet()) {

      if (count == -1) {
        count = entry.getValue();
      } else if (count != entry.getValue()) {
        return false;
      }
    }

    return true;
  }

  /**
   * 2315. Count Asterisks You are given a string s, where every two consecutive vertical bars '|'
   * are grouped into a pair. In other words, the 1st and 2nd '|' make a pair, the 3rd and 4th '|'
   * make a pair, and so forth.
   *
   * <p>Return the number of '*' in s, excluding the '*' between each pair of '|'.
   *
   * <p>Note: that each '|' will belong to exactly one pair.
   *
   * <p>Example 1: Input: s = "l|*e*et|c**o|*de|" Output: 2 Explanation: The considered characters
   * are underlined: "l|*e*et|c**o|*de|". The characters between the first and second '|' are
   * excluded from the answer. Also, the characters between the third and fourth '|' are excluded
   * from the answer. There are 2 asterisks considered. Therefore, we return 2.
   *
   * <p>Example 2: Input: s = "iamprogrammer" Output: 0 Explanation: In this example, there are no
   * asterisks in s. Therefore, we return 0.
   *
   * <p>Example 3: Input: s = "yo|uar|e**|b|e***au|tifu|l" Output: 5 Explanation: The considered
   * characters are underlined: "yo|uar|e**|b|e***au|tifu|l". There are 5 asterisks considered.
   * Therefore, we return 5.
   *
   * <p>Constraints: 1 <= s.length <= 1000 s consists of lowercase English letters, vertical bars
   * '|', and asterisks '*'. s contains an even number of vertical bars '|'.
   *
   * @param s
   * @return int
   */
  public int countAsterisks(String s) {
    boolean open = false;
    int count = 0;

    for (char ch : s.toCharArray()) {
      if (ch == '|') {
        open = !open;
      } else if (!open && (ch == '*')) {
        count++;
      }
    }

    return count;
  }

  /**
   * 2697. Lexicographically Smallest Palindrome You are given a string s consisting of lowercase
   * English letters, and you are allowed to perform operations on it. In one operation, you can
   * replace a character in s with another lowercase English letter.
   *
   * <p>Your task is to make s a palindrome with the minimum number of operations possible. If there
   * are multiple palindromes that can be made using the minimum number of operations, make the
   * lexicographically smallest one.
   *
   * <p>A string a is lexicographically smaller than a string b (of the same length) if in the first
   * position where a and b differ, string a has a letter that appears earlier in the alphabet than
   * the corresponding letter in b.
   *
   * <p>Return the resulting palindrome string.
   *
   * <p>Example 1: Input: s = "egcfe" Output: "efcfe" Explanation: The minimum number of operations
   * to make "egcfe" a palindrome is 1, and the lexicographically smallest palindrome string we can
   * get by modifying one character is "efcfe", by changing 'g'.
   *
   * <p>Example 2: Input: s = "abcd" Output: "abba" Explanation: The minimum number of operations to
   * make "abcd" a palindrome is 2, and the lexicographically smallest palindrome string we can get
   * by modifying two characters is "abba".
   *
   * <p>Example 3: Input: s = "seven" Output: "neven" Explanation: The minimum number of operations
   * to make "seven" a palindrome is 1, and the lexicographically smallest palindrome string we can
   * get by modifying one character is "neven".
   *
   * <p>Constraints: 1 <= s.length <= 1000 s consists of only lowercase English letters.
   *
   * @param s
   * @return String
   */
  public String makeSmallestPalindrome(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
      char c = (char) Math.min((int) s.charAt(i), (int) s.charAt(s.length() - 1 - i));
      s =
          s.substring(0, i)
              + c
              + s.substring(i + 1, s.length() - i - 1)
              + c
              + s.substring(s.length() - i);
    }
    return s;
  }

  /**
   * 8. String to Integer (atoi) Implement the myAtoi(string s) function, which converts a string to
   * a 32-bit signed integer (similar to C/C++'s atoi function).
   *
   * <p>The algorithm for myAtoi(string s) is as follows:
   *
   * <p>Read in and ignore any leading whitespace. Check if the next character (if not already at
   * the end of the string) is '-' or '+'. Read this character in if it is either. This determines
   * if the final result is negative or positive respectively. Assume the result is positive if
   * neither is present.
   *
   * <p>Read in next the characters until the next non-digit character or the end of the input is
   * reached. The rest of the string is ignored.
   *
   * <p>Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were
   * read, then the integer is 0. Change the sign as necessary (from step 2). If the integer is out
   * of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains
   * in the range. Specifically, integers less than -231 should be clamped to -231, and integers
   * greater than 231 - 1 should be clamped to 231 - 1.
   *
   * <p>Return the integer as the final result. Note: Only the space character ' ' is considered a
   * whitespace character. Do not ignore any characters other than the leading whitespace or the
   * rest of the string after the digits.
   *
   * <p>Example 1: Input: s = "42" Output: 42 Explanation: The underlined characters are what is
   * read in, the caret is the current reader position. Step 1: "42" (no characters read because
   * there is no leading whitespace) ^ Step 2: "42" (no characters read because there is neither a
   * '-' nor '+') ^ Step 3: "42" ("42" is read in) ^ The parsed integer is 42. Since 42 is in the
   * range [-231, 231 - 1], the final result is 42.
   *
   * <p>Example 2: Input: s = " -42" Output: -42 Explanation: Step 1: " -42" (leading whitespace is
   * read and ignored) ^ Step 2: " -42" ('-' is read, so the result should be negative) ^ Step 3: "
   * -42" ("42" is read in) ^ The parsed integer is -42. Since -42 is in the range [-231, 231 - 1],
   * the final result is -42.
   *
   * <p>Example 3: Input: s = "4193 with words" Output: 4193 Explanation: Step 1: "4193 with words"
   * (no characters read because there is no leading whitespace) ^ Step 2: "4193 with words" (no
   * characters read because there is neither a '-' nor '+') ^ Step 3: "4193 with words" ("4193" is
   * read in; reading stops because the next character is a non-digit) ^ The parsed integer is 4193.
   * Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
   *
   * <p>Constraints: 0 <= s.length <= 200 s consists of English letters (lower-case and upper-case),
   * digits (0-9), ' ', '+', '-', and '.'.
   *
   * @param s
   * @return int
   */
  public int myAtoi(String s) {
    /*
    s=s.trim();
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < s.length(); i++)    {
        if ((s.charAt(i) == '+' || s.charAt(i) == '-') &&
                Character.isDigit(s.charAt(i+1)))                      {
            builder.append(s.charAt(i));
        } else if (Character.isDigit(s.charAt(i)))                  {
            builder.append(s.charAt(i));
        } else if (((s.charAt(i) == ' ') && !builder.isEmpty()) ||
                !Character.isDigit(s.charAt(i)))                {
            break;
        }
    }

    if (builder.isEmpty())  {
        return 0;
    }
    return Integer.parseInt(builder.toString());
    */

    s = s.trim();
    if (s.isEmpty()) {
      return 0;
    }

    int ans = 0, i = 0;
    boolean neg = s.charAt(0) == '-';
    boolean pos = s.charAt(0) == '+';

    if (neg || pos) {
      i++;
    }

    while (i < s.length() && Character.isDigit(s.charAt(i))) {
      int digit = s.charAt(i) - '0';

      if (ans > Integer.MAX_VALUE / 10
          || (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
        return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }

      ans = ans * 10 + digit;
      i++;
    }

    return neg ? -ans : ans;
  }

  /**
   * 10. Regular Expression Matching Given an input string s and a pattern p, implement regular
   * expression matching with support for '.' and '*' where:
   *
   * <p>'.' Matches any single character. '*' Matches zero or more of the preceding element. The
   * matching should cover the entire input string (not partial).
   *
   * <p>Example 1: Input: s = "aa", p = "a" Output: false Explanation: "a" does not match the entire
   * string "aa".
   *
   * <p>Example 2: Input: s = "aa", p = "a*" Output: true Explanation: '*' means zero or more of the
   * preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
   *
   * <p>Example 3: Input: s = "ab", p = ".*" Output: true Explanation: ".*" means "zero or more (*)
   * of any character (.)".
   *
   * <p>Constraints: 1 <= s.length <= 20 1 <= p.length <= 20 s contains only lowercase English
   * letters. p contains only lowercase English letters, '.', and '*'. It is guaranteed for each
   * appearance of the character '*', there will be a previous valid character to match.
   *
   * @param text
   * @param pattern
   * @return boolean
   */
  public boolean isMatch(String text, String pattern) {
    regexMemo = new Result[text.length() + 1][pattern.length() + 1];
    return regexMatch(0, 0, text, pattern);
  }

  private boolean regexMatch(int itxt, int ipat, String text, String pattern) {
    if (regexMemo[itxt][ipat] != null) {
      return regexMemo[itxt][ipat] == Result.TRUE;
    }
    boolean ans;
    if (ipat == pattern.length()) {
      ans = itxt == text.length();
    } else {
      boolean first_match =
          (itxt < text.length()
              && (pattern.charAt(ipat) == text.charAt(itxt) || pattern.charAt(ipat) == '.'));

      if (ipat + 1 < pattern.length() && pattern.charAt(ipat + 1) == '*') {
        ans =
            (regexMatch(itxt, ipat + 2, text, pattern)
                || first_match && regexMatch(itxt + 1, ipat, text, pattern));
      } else {
        ans = first_match && regexMatch(itxt + 1, ipat + 1, text, pattern);
      }
    }
    regexMemo[itxt][ipat] = ans ? Result.TRUE : Result.FALSE;
    return ans;
  }

  /**
   * 3. Longest Substring Without Repeating Characters Given a string s, find the length of the
   * longest substring without repeating characters.
   *
   * <p>Example 1: Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length
   * of 3.
   *
   * <p>Example 2: Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length of
   * 1.
   *
   * <p>Example 3: Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the length
   * of 3. Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
   *
   * <p>Constraints: 0 <= s.length <= 5 * 104 s consists of English letters, digits, symbols and
   * spaces.
   *
   * @param s
   * @return <code>int</code>
   */
  public int lengthOfLongestSubstring(String s) {

    return -1;
  }

  /**
   * 67. Add Binary Given two binary strings a and b, return their sum as a binary string.
   *
   * <p>Example 1: Input: a = "11", b = "1" Output: "100"
   *
   * <p>Example 2: Input: a = "1010", b = "1011" Output: "10101"
   *
   * <p>Constraints: 1 <= a.length, b.length <= 104 a and b consist only of '0' or '1' characters.
   * Each string does not contain leading zeros except for the zero itself.
   *
   * @param num1
   * @param num2
   * @return <code>String</code>
   */
  public String addBinary(String num1, String num2) {
    StringBuilder builder = new StringBuilder();
    int carryOver = 0;
    int maxLength = Math.max(num1.length(), num2.length());
    // To keep both the strings' length same
    num1 = "0".repeat(maxLength - num1.length()).concat(num1);
    num2 = "0".repeat(maxLength - num2.length()).concat(num2);

    for (int i = maxLength - 1; i >= 0; i--) {

      int sum = carryOver;

      sum += num1.charAt(i) - '0';
      sum += num2.charAt(i) - '0';

      builder.append(sum % 2);
      carryOver = sum / 2;
    }
    if (carryOver > 0) builder.append(carryOver);

    return builder.reverse().toString();
  }

  /**
   * 49. Group Anagrams Given an array of strings strs, group the anagrams together. You can return
   * the answer in any order.
   *
   * <p>An Anagram is a word or phrase formed by rearranging the letters of a different word or
   * phrase, typically using all the original letters exactly once.
   *
   * <p>Example 1: Input: strs = ["eat","tea","tan","ate","nat","bat"] Output:
   * [["bat"],["nat","tan"],["ate","eat","tea"]]
   *
   * <p>Example 2: Input: strs = [""] Output: [[""]]
   *
   * <p>Example 3: Input: strs = ["a"] Output: [["a"]] <code>
   * Constraints:
   * 1 <= strs.length <= 10^4
   * 0 <= strs[i].length <= 100
   * strs[i] consists of lowercase English letters.
   * </code>
   *
   * @param strs
   * @return <code>List<List<String>></code>
   * @tag("String","leetcode75")
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String word : strs) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sortedString = new String(chars);

      if (!map.containsKey(sortedString)) {
        map.put(sortedString, new ArrayList<>());
      }
      map.get(sortedString).add(word);
    }

    if (map.isEmpty()) {
      return List.of(List.of());
    }

    return new ArrayList<>(map.values());
  }

  /**
   * 168. Excel Sheet Column Title Given an integer columnNumber, return its corresponding column
   * title as it appears in an Excel sheet.
   *
   * <p>For example: A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ...
   *
   * <p>Example 1: Input: columnNumber = 1 Output: "A"
   *
   * <p>Example 2: Input: columnNumber = 28 Output: "AB"
   *
   * <p>Example 3: Input: columnNumber = 701 Output: "ZY"
   *
   * <p>Constraints: 1 <= columnNumber <= 231 - 1
   *
   * @param columnNumber
   * @return <code>String</code>
   */
  public String convertToTitle(int columnNumber) {
    StringBuilder builder = new StringBuilder();

    while (columnNumber > 0) {
      columnNumber--;
      char c = (char) (columnNumber % 26 + 'A');
      columnNumber /= 26;
      builder.append(c);
    }

    return builder.reverse().toString();
  }

  /**
   * 171. Excel Sheet Column Number Given a string columnTitle that represents the column title as
   * appears in an Excel sheet, return its corresponding column number.
   *
   * <p>For example: A -> 1 B -> 2 C -> 3 ... X -> 24 Y -> 25 Z -> 26 AA -> 27 AB -> 28 ...
   *
   * <p>Example 1: Input: columnTitle = "A" Output: 1
   *
   * <p>Example 2: Input: columnTitle = "AB" Output: 28
   *
   * <p>Example 3: Input: columnTitle = "ZY" Output: 701
   *
   * <p>Constraints: 1 <= columnTitle.length <= 7 columnTitle consists only of uppercase English
   * letters. columnTitle is in the range ["A", "FXSHRXW"].
   *
   * @param columnTitle
   * @return <code>int</code>
   */
  public int titleToNumber(String columnTitle) {
    if (columnTitle == null) return -1;

    int titleNum = 0;
    for (char ch : columnTitle.toUpperCase().toCharArray()) {
      titleNum *= 26;
      titleNum += (ch - 'A') + 1;
    }

    return titleNum;
  }

  /**
   * 459. Repeated Substring Pattern <br>
   * Given a string s, check if it can be constructed by taking a substring of it and appending
   * multiple copies of the substring together.
   *
   * <p>Example 1: Input: s = "abab" Output: true Explanation: It is the substring "ab" twice.
   *
   * <p>Example 2: Input: s = "aba" Output: false
   *
   * <p>Example 3: Input: s = "abcabcabcabc" Output: true Explanation: It is the substring "abc"
   * four times or the substring "abcabc" twice.
   *
   * <p>Constraints: 1 <= s.length <= 104 s consists of lowercase English letters.
   *
   * @param s
   * @return <code>boolean</code>
   */
  public boolean repeatedSubstringPattern(String s) {

    Map<Character, Long> charCountMap =
        s.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    return charCountMap.values().stream().anyMatch(val -> val <= 1);
  }
}
