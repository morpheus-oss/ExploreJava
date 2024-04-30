package dev.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Leetcode problems of 'Arrays' category. */
public class ArrayProblems {

  /**
   * 1920. Build Array from Permutation
   *
   * <p>Given a zero-based permutation nums (0-indexed), build an array ans of the same length where
   * ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
   *
   * <p>A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1
   * (inclusive).
   *
   * <p>Example 1:
   *
   * <p>Input: nums = [0,2,1,5,3,4] Output: [0,1,2,4,5,3] Explanation: The array ans is built as
   * follows: ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]],
   * nums[nums[5]]] = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]] = [0,1,2,4,5,3] Example
   * 2:
   *
   * <p>Input: nums = [5,0,1,2,3,4] Output: [4,5,0,1,2,3] Explanation: The array ans is built as
   * follows: ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]],
   * nums[nums[5]]] = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]] = [4,5,0,1,2,3]
   *
   * <p>Constraints:
   *
   * <p>1 <= nums.length <= 1000 0 <= nums[i] < nums.length The elements in nums are distinct.
   *
   * <p>Follow-up: Can you solve it without using an extra space (i.e., O(1) memory)?
   */

  /**
   * 1929. Concatenation of Array Given an integer array nums of length n, you want to create an
   * array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n
   * (0-indexed). Specifically, ans is the concatenation of two nums arrays. Return the array ans.
   *
   * <p>Example 1:
   *
   * <p>Input: nums = [1,2,1] Output: [1,2,1,1,2,1] Explanation: The array ans is formed as follows:
   * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]] - ans = [1,2,1,1,2,1] Example 2:
   *
   * <p>Input: nums = [1,3,2,1] Output: [1,3,2,1,1,3,2,1] Explanation: The array ans is formed as
   * follows: - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]] - ans =
   * [1,3,2,1,1,3,2,1]
   *
   * <p>Constraints:
   *
   * <p>n == nums.length 1 <= n <= 1000 1 <= nums[i] <= 1000
   */
  int[] concatenateArray(int[] nums) {
    if (nums == null || nums.length < 1) {
      return nums;
    }

    int[] ans = new int[2 * nums.length];

    System.arraycopy(nums, 0, ans, 0, nums.length);
    System.arraycopy(nums, 0, ans, nums.length, nums.length);

    return ans;
  }

  /**
   * 1512. Number of Good Pairs Given an array of integers nums, return the number of good pairs.
   *
   * <p>A pair (i, j) is called good if nums[i] == nums[j] and i < j.
   *
   * <p>Example 1:
   *
   * <p>Input: nums = [1,2,3,1,1,3] Output: 4 Explanation: There are 4 good pairs (0,3), (0,4),
   * (3,4), (2,5) 0-indexed. Example 2:
   *
   * <p>Input: nums = [1,1,1,1] Output: 6 Explanation: Each pair in the array are good. Example 3:
   *
   * <p>Input: nums = [1,2,3] Output: 0
   *
   * <p>Constraints:
   *
   * <p>1 <= nums.length <= 100 1 <= nums[i] <= 100
   */
  int countGoodPairs(int[] array) {
    int ans = 0;
    int[] count = new int[101];

    for (int i : array) {
      ans += count[i]++;
    }

    return ans;
  }

  /**
   * 136. Single Number Given a non-empty array of integers nums, every element appears twice except
   * for one. Find that single one. You must implement a solution with a linear runtime complexity
   * and use only constant extra space.
   *
   * <p>Example 1: Input: nums = [2,2,1] Output: 1
   *
   * <p>Example 2: Input: nums = [4,1,2,1,2] Output: 4
   *
   * <p>Example 3: Input: nums = [1] Output: 1
   *
   * <p>Constraints: 1 <= nums.length <= 3 * 104 -3 * 104 <= nums[i] <= 3 * 104 Each element in the
   * array appears twice except for one element which appears only once.
   */
  int singleNumber(int[] nums) {
    if (nums.length == 0) return 0;

    int out = 0;

    for (int n : nums) {
      out ^= n;
    }
    return out;
  }

  /**
   * 137. Single Number II Given an integer array nums where every element appears three times
   * except for one, which appears exactly once. Find the single element and return it. You must
   * implement a solution with a linear runtime complexity and use only constant extra space.
   *
   * <p>Example 1: Input: nums = [2,2,3,2] Output: 3
   *
   * <p>Example 2: Input: nums = [0,1,0,1,0,1,99] Output: 99
   *
   * <p>Constraints: 1 <= nums.length <= 3 * 10^4 -2^31 <= nums[i] <= 2^31 - 1 Each element in nums
   * appears exactly three times except for one element which appears once.
   */
  int singleNumber2(int[] nums) {
    /*
    int ones = 0;
    int twos = 0;

    for (final int num : nums) {
      ones ^= (num & ~twos);
      twos ^= (num & ~ones);
    }

    return ones;
     */
    Map<Integer, Long> map =
        Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    for (Map.Entry<Integer, Long> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        return Math.toIntExact(entry.getKey());
      }
    }

    return 0;
  }

  /**
   * 260. Single Number III Given an integer array nums, in which exactly two elements appear only
   * once and all the other elements appear exactly twice. Find the two elements that appear only
   * once. You can return the answer in any order.
   *
   * <p>You must write an algorithm that runs in linear runtime complexity and uses only constant
   * extra space.
   *
   * <p>Example 1: Input: nums = [1,2,1,3,2,5] Output: [3,5] Explanation: [5, 3] is also a valid
   * answer.
   *
   * <p>Example 2: Input: nums = [-1,0] Output: [-1,0]
   *
   * <p>Example 3: Input: nums = [0,1] Output: [1,0]
   *
   * <p>Constraints: 2 <= nums.length <= 3 * 104 -231 <= nums[i] <= 231 - 1 Each integer in nums
   * will appear twice, only two integers will appear once.
   */
  int[] singleNumber3(int[] nums) {
    /*
    int num=0;
    for(int i=0;i<nums.length;i++){
        num=num^nums[i];
    }

    int rmsb=num & -num;
    int[] ans = new int[2];
    for(int i=0;i<nums.length;i++){
        if((rmsb & nums[i])==0){
            ans[0] ^= nums[i];
        } else  {
            ans[1] ^= nums[i];
        }
    }

    return ans;
     */
    if (nums == null || nums.length < 3) return nums;

    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      if (set.contains(n)) {
        set.remove(n);
      } else {
        set.add(n);
      }
    }
    return set.stream().mapToInt(i -> i).toArray();
  }
}
