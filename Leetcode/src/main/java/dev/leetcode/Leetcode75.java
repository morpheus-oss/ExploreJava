package dev.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode75 {

    /**
     * 1071. Greatest Common Divisor of Strings
     * For two strings s and t, we say "t divides s" if and only if
     * s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
     *
     * Given two strings str1 and str2, return the largest string x such that x
     * divides both str1 and str2.
     *
     * Example 1:
     * Input: str1 = "ABCABC", str2 = "ABC"
     * Output: "ABC"
     *
     * Example 2:
     * Input: str1 = "ABABAB", str2 = "ABAB"
     * Output: "AB"
     *
     * Example 3:
     * Input: str1 = "LEET", str2 = "CODE"
     * Output: ""
     *
     * Constraints:
     * 1 <= str1.length, str2.length <= 1000
     * str1 and str2 consist of English uppercase letters.
     */
    String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals(str2+str1)) return "";

        int gcd = gcd(str1.length(), str2.length());

        return str1.substring(0,gcd);
    }

    private int gcd(int a, int b)   {
        return (b == 0) ? a : gcd(b, a%b);
    }

    /**
     * 1431. Kids With the Greatest Number of Candies
     * There are n kids with candies. You are given an integer array candies,
     * where each candies[i] represents the number of candies the ith kid has,
     * and an integer extraCandies, denoting the number of extra candies that you have.
     *
     * Return a boolean array result of length n, where result[i] is true if, after
     * giving the ith kid all the extraCandies, they will have the greatest number of
     * candies among all the kids, or false otherwise.
     *
     * Note that multiple kids can have the greatest number of candies.
     *
     * Example 1:
     * Input: candies = [2,3,5,1,3], extraCandies = 3
     * Output: [true,true,true,false,true]
     * Explanation: If you give all extraCandies to:
     * - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
     * - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
     * - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
     * - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
     * - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
     *
     * Example 2:
     * Input: candies = [4,2,1,1,2], extraCandies = 1
     * Output: [true,false,false,false,false]
     * Explanation: There is only 1 extra candy.
     * Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
     *
     * Example 3:
     * Input: candies = [12,1,12], extraCandies = 10
     * Output: [true,false,true]
     *
     *
     * Constraints:
     * n == candies.length
     * 2 <= n <= 100
     * 1 <= candies[i] <= 100
     * 1 <= extraCandies <= 50
     */
    List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> kidsMaxCandies = new ArrayList<>();

        if (candies == null || candies.length < 1)  {
            return kidsMaxCandies;
        }
        /*
        int maxCount = 0;
        for (int candy : candies) {
            maxCount = Math.max(candy, maxCount);
        }
         */
        int maxCount = Arrays.stream(candies).max().getAsInt();
        for (int candy : candies)   {
            kidsMaxCandies.add((candy+extraCandies) >= maxCount);
        }
        return kidsMaxCandies;
    }

}
