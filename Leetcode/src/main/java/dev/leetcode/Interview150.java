package dev.leetcode;

/** Leetcode problems of 'Top Interview 150' category. */
public class Interview150 {

  /**
   * 88. Merge Sorted Array
   *
   * <pre> You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two
   * integers m and n, representing the number of elements in nums1 and nums2 respectively.
   *
   * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
   *
   * The final sorted array should not be returned by the function, but instead be stored inside
   * the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements
   * denote the elements that should be merged, and the last n elements are set to 0 and should
   * be ignored. nums2 has a length of n.
   *
   * Example 1:
   * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
   * Output: [1,2,2,3,5,6]
   * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
   * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
   *
   * Example 2:
   * Input: nums1 = [1], m = 1, nums2 = [], n = 0
   * Output: [1]
   * Explanation: The arrays we are merging are [1] and [].
   * The result of the merge is [1].
   *
   * Example 3:
   * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
   * Output: [1]
   * Explanation: The arrays we are merging are [] and [1].
   * The result of the merge is [1].
   * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the
   * merge result can fit in nums1.
   * </pre>
   *
   * Constraints:
   *
   * <ul>
   *   <li>nums1.length == m + n
   *   <li>nums2.length == n
   *   <li>0 <= m, n <= 200
   *   <li>1 <= m + n <= 200
   *   <li>-10^9 <= nums1[i], nums2[j] <= 10^9
   * </ul>
   *
   * <p>Follow up: Can you come up with an algorithm that runs in O(m + n) time?
   *
   * @param nums1 - array of integers in ascending order
   * @param m - valid number of elements in <code>nums1</code>
   * @param nums2 - array of integers in ascending order
   * @param n - valid number of elements in <code>nums2</code>
   * @return array of merged integer arrays <code>nums1</code> and <code>nums2</code>
   */
  public int[] merge(int[] nums1, int m, int[] nums2, int n) {
    if (nums2 == null || nums2.length == 0) return nums1;

    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;

    while (j >= 0) {
      if (i >= 0 && nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }

    return nums1;
  }

  /**
   * 27. Remove Element
   *
   * <pre>Given an integer array nums and an integer val, remove all occurrences of val in
   * nums in-place. The order of the elements may be changed. Then return the number of
   * elements in nums which are not equal to val.
   *
   * Consider the number of elements in nums which are not equal to val be k, to get accepted,
   * you need to do the following things:
   *
   * Change the array nums such that the first k elements of nums contain the elements which
   * are not equal to val. The remaining elements of nums are not important as well as the
   * size of nums.
   *
   * Return k.
   *
   * Custom Judge:
   * The judge will test your solution with the following code:
   *
   * int[] nums = [...]; // Input array
   * int val = ...; // Value to remove
   * int[] expectedNums = [...]; // The expected answer with correct length.
   *                             // It is sorted with no values equaling val.
   *
   * int k = removeElement(nums, val); // Calls your implementation
   *
   * assert k == expectedNums.length;
   * sort(nums, 0, k); // Sort the first k elements of nums
   * for (int i = 0; i < actualLength; i++) {
   *     assert nums[i] == expectedNums[i];
   * }
   * If all assertions pass, then your solution will be accepted.
   *
   * Example 1:
   * Input: nums = [3,2,2,3], val = 3
   * Output: 2, nums = [2,2,_,_]
   * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
   * It does not matter what you leave beyond the returned k (hence they are underscores).
   *
   * Example 2:
   * Input: nums = [0,1,2,2,3,0,4,2], val = 2
   * Output: 5, nums = [0,1,4,0,3,_,_,_]
   * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
   * Note that the five elements can be returned in any order.
   * It does not matter what you leave beyond the returned k (hence they are underscores).
   * </pre>
   *
   * Constraints:
   *
   * <ul>
   *   <li>0 <= nums.length <= 100
   *   <li>0 <= nums[i] <= 50
   *   <li>0 <= val <= 100
   * </ul>
   *
   * @param nums
   * @param val
   * @return
   */
  public int removeElement(int[] nums, int val) {
    int index = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[index++] = nums[i];
      }
    }

    return index;
  }

  /**
   * 26. Remove Duplicates from Sorted Array
   *
   * <pre>
   * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such
   * that each unique element appears only once. The relative order of the elements should be kept
   * the same. Then return the number of unique elements in nums.
   *
   * Consider the number of unique elements of nums to be k, to get accepted, you need to do the
   * following things:
   *
   * Change the array nums such that the first k elements of nums contain the unique elements in the
   * order they were present in nums initially. The remaining elements of nums are not important
   * as well as the size of nums.
   *
   * Return k.
   *
   * Custom Judge:
   * The judge will test your solution with the following code:
   *
   * int[] nums = [...]; // Input array
   * int[] expectedNums = [...]; // The expected answer with correct length
   *
   * int k = removeDuplicates(nums); // Calls your implementation
   *
   * assert k == expectedNums.length;
   * for (int i = 0; i < k; i++) {
   *     assert nums[i] == expectedNums[i];
   * }
   * If all assertions pass, then your solution will be accepted.
   *
   *
   * Example 1:
   * Input: nums = [1,1,2]
   * Output: 2, nums = [1,2,_]
   * Explanation: Your function should return k = 2, with the first two elements of nums being
   * 1 and 2 respectively.
   * It does not matter what you leave beyond the returned k (hence they are underscores).
   *
   * Example 2:
   *
   * Input: nums = [0,0,1,1,1,2,2,3,3,4]
   * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
   * Explanation: Your function should return k = 5, with the first five elements of nums being
   * 0, 1, 2, 3, and 4 respectively.
   *
   * It does not matter what you leave beyond the returned k (hence they are underscores).
   * </pre>
   *
   * Constraints:
   *
   * <ul>
   *   <li>1 <= nums.length <= 3 * 104
   *   <li>-100 <= nums[i] <= 100
   *   <li>nums is sorted in non-decreasing order.
   * </ul>
   *
   * @param nums
   * @return
   */
  public int removeDuplicates(int[] nums) {
    int index = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[index++] = nums[i];
      }
    }
    return index;
  }

  /**
   * 80. Remove Duplicates from Sorted Array II
   *
   * <pre>
   * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place
   * such that each unique element appears at most twice. The relative order of the elements
   * should be kept the same.
   *
   * Since it is impossible to change the length of the array in some languages, you must instead
   * have the result be placed in the first part of the array nums. More formally, if there are
   * k elements after removing the duplicates, then the first k elements of nums should hold the
   * final result. It does not matter what you leave beyond the first k elements.
   *
   * Return k after placing the final result in the first k slots of nums.
   *
   * Do not allocate extra space for another array. You must do this by modifying the input array
   * in-place with O(1) extra memory.
   *
   * Custom Judge:
   * The judge will test your solution with the following code:
   *
   * int[] nums = [...]; // Input array
   * int[] expectedNums = [...]; // The expected answer with correct length
   *
   * int k = removeDuplicates(nums); // Calls your implementation
   *
   * assert k == expectedNums.length;
   * for (int i = 0; i < k; i++) {
   *     assert nums[i] == expectedNums[i];
   * }
   * If all assertions pass, then your solution will be accepted.
   *
   *
   * Example 1:
   * Input: nums = [1,1,1,2,2,3]
   * Output: 5, nums = [1,1,2,2,3,_]
   * Explanation: Your function should return k = 5, with the first five elements of nums being
   * 1, 1, 2, 2 and 3 respectively.
   *
   * It does not matter what you leave beyond the returned k (hence they are underscores).
   *
   * Example 2:
   * Input: nums = [0,0,1,1,1,1,2,3,3]
   * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
   * Explanation: Your function should return k = 7, with the first seven elements of nums being
   * 0, 0, 1, 1, 2, 3 and 3 respectively.
   *
   * It does not matter what you leave beyond the returned k (hence they are underscores).
   * </pre>
   *
   * Constraints:
   *
   * <ul>
   *   <li>1 <= nums.length <= 3 * 10^4 </li>
   *   <li>-10^4 <= nums[i] <= 10^4 </li>
   *   <li>nums is sorted in non-decreasing order. </li>
   * </ul>
   *
   * @param nums
   * @return
   */
  public int removeDuplicates2(int[] nums) {
    int index = 1;
    for (int i = 1; i < nums.length; i++) {
      if (index == 1 || nums[i] != nums[index - 2]) {
        nums[index++] = nums[i];
      }
    }
    return index;
  }

  /**
   * 169. Majority Element
   * <pre>
   * Given an array nums of size n, return the majority element.
   *
   * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume
   * that the majority element always exists in the array.
   *
   * Example 1:
   * Input: nums = [3,2,3]
   * Output: 3
   *
   * Example 2:
   * Input: nums = [2,2,1,1,1,2,2]
   * Output: 2
   * </pre>
   *
   * Constraints:
   * <ul>
   * <li>n == nums.length </li>
   * <li>1 <= n <= 5 * 10^4 </li>
   * <li>-10^9 <= nums[i] <= 10^9 </li>
   * </ul>
   * Follow-up: Could you solve the problem in linear time and in O(1) space?
   *
   * <p>
   * @see <a href="https://leetcode.com/problems/majority-element/solutions/3676530/3-method-s-beats-100-c-java-python-beginner-friendly">
   *     Moore Voting Algorithm</a>
   * </p>
   *
   * @param nums
   * @return
   */
  public int majorityElement(int[] nums) {
    int num = 0;
    int count = 0;

    for (int n : nums)  {
      num = (count == 0) ? n : num;

      if (n == num)   {
        count++;
      } else {
        count--;
      }
    }

    return num;
  }

  /**
   * 189. Rotate Array
   * <pre>
   * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
   *
   *
   *
   * Example 1:
   *
   * Input: nums = [1,2,3,4,5,6,7], k = 3
   * Output: [5,6,7,1,2,3,4]
   * Explanation:
   * rotate 1 steps to the right: [7,1,2,3,4,5,6]
   * rotate 2 steps to the right: [6,7,1,2,3,4,5]
   * rotate 3 steps to the right: [5,6,7,1,2,3,4]
   * Example 2:
   *
   * Input: nums = [-1,-100,3,99], k = 2
   * Output: [3,99,-1,-100]
   * Explanation:
   * rotate 1 steps to the right: [99,-1,-100,3]
   * rotate 2 steps to the right: [3,99,-1,-100]
   * </pre>
   *
   * Constraints:
   * <ul>
   * <li>1 <= nums.length <= 10^5 </li>
   * <li>-2^31 <= nums[i] <= 2^31 - 1 </li>
   * <li>0 <= k <= 10^5 </li>
   * </ul>
   *
   * Follow up:
   * <ul>
   * <li>Try to come up with as many solutions as you can. There are at least three different ways to solve this problem. </li>
   * <li>Could you do it in-place with O(1) extra space? </li>
   * </ul>
   * @param nums
   * @param k
   */
  public int[] rotate(int[] nums, int k) {
    if (k <= 0)  return nums;
    if (nums == null || nums.length < 1)    return nums;

    k = (k > nums.length) ? (k % nums.length) : k;

    reverseArray(nums, 0, nums.length - k - 1);
    reverseArray(nums, nums.length - k, nums.length - 1);
    reverseArray(nums, 0, nums.length - 1);

    return nums;
  }

  private void reverseArray(int[] array, int leftIdx, int rightIdx)   {
    while (leftIdx < rightIdx)  {
      int temp = array[leftIdx];
      array[leftIdx] = array[rightIdx];
      array[rightIdx] = temp;

      leftIdx++;
      rightIdx--;
    }
  }

  /**
   * 121. Best Time to Buy and Sell Stock
   * <pre>
   * You are given an array prices where prices[i] is the price of a given stock on the ith day.
   *
   * You want to maximize your profit by choosing a single day to buy one stock and choosing a different
   * day in the future to sell that stock.
   *
   * <i>Return the maximum profit you can achieve from this transaction.
   * If you cannot achieve any profit, return 0. </i>
   *
   * Example 1:
   * Input: prices = [7,1,5,3,6,4]
   * Output: 5
   * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
   * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
   *
   * Example 2:
   * Input: prices = [7,6,4,3,1]
   * Output: 0
   * Explanation: In this case, no transactions are done and the max profit = 0.
   * </pre>
   *
   * Constraints:
   * <ul>
   * <li>1 <= prices.length <= 10^5 </li>
   * <li>0 <= prices[i] <= 10^4 </li>
   * </ul>
   *
   * <p>
   * @see
   * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solutions/3914105/most-optimized-solution-easy-to-understand-c-java-python">
   * Dynamic Programming (Easy) - Solution Explained</a>
   * </p>
   * <p>
   * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solutions/4868897/most-optimized-kadane-s-algorithm-java-c-python-rust-javascript">
   *     With Kadane's Algorithm</a>
   * </p>
   *
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    int buy = prices[0];
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < buy)    {
        buy = prices[i];
      } else if (prices[i]-buy > maxProfit)   {
        maxProfit = prices[i]-buy;
      }
    }

    return maxProfit;
  }

  /**
   * 122. Best Time to Buy and Sell Stock II
   * <pre>
   * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
   *
   * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of
   * the stock at any time. However, you can buy it then immediately sell it on the same day.
   *
   * Find and return the maximum profit you can achieve.
   *
   * Example 1:
   * Input: prices = [7,1,5,3,6,4]
   * Output: 7
   * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
   * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
   * Total profit is 4 + 3 = 7.
   *
   * Example 2:
   * Input: prices = [1,2,3,4,5]
   * Output: 4
   * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
   * Total profit is 4.
   *
   * Example 3:
   * Input: prices = [7,6,4,3,1]
   * Output: 0
   * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve
   * the maximum profit of 0.
   * </pre>
   *
   * Constraints:
   * <ul>
   * <li>1 <= prices.length <= 3 * 10^4 </li>
   * <li>0 <= prices[i] <= 10^4 </li>
   * </ul>
   *
   * @param prices
   * @return
   */
  public int maxProfit2(int[] prices) {
    int lastPrice = prices[0];
    int buy = 0;
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      buy = Math.min(prices[i-1], prices[i]);
      if (buy < prices[i])  {
        maxProfit += prices[i]-buy;
      }
    }

    return maxProfit;
  }

  /**
   * 55. Jump Game
   * <pre>
   * You are given an integer array nums. You are initially positioned at the array's first index,
   * and each element in the array represents your maximum jump length at that position.
   *
   * Return true if you can reach the last index, or false otherwise.
   *
   * Example 1:
   * Input: nums = [2,3,1,1,4]
   * Output: true
   * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
   *
   * Example 2:
   * Input: nums = [3,2,1,0,4]
   * Output: false
   * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
   * which makes it impossible to reach the last index.
   * </pre>
   *
   * Constraints:
   * <ul>
   * <li>1 <= nums.length <= 104 </li>
   * <li>0 <= nums[i] <= 105 </li>
   * </ul>
   * <p>
   * @see <a href="https://leetcode.com/problems/jump-game/solutions/3758301/java-easy-solution-with-explanation">
   *     Explanation</a>
   * </p>
   * @param nums
   * @return
   */
  public boolean canJump(int[] nums) {
    int reachable = 0;
    for(int i = 0; i < nums.length; i ++) {
      if(i > reachable) return false;
      reachable = Math.max(reachable, i + nums[i]);
    }
    return true;
  }

  /**
   * 45. Jump Game II
   * <pre>
   * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
   *
   * Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
   * if you are at nums[i], you can jump to any nums[i + j] where:
   *
   * 0 <= j <= nums[i] and
   * i + j < n
   * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated
   * such that you can reach nums[n - 1].
   *
   * Example 1:
   * Input: nums = [2,3,1,1,4]
   * Output: 2
   * Explanation: The minimum number of jumps to reach the last index is 2.
   * Jump 1 step from index 0 to 1, then 3 steps to the last index.
   *
   * Example 2:
   * Input: nums = [2,3,0,1,4]
   * Output: 2
   * </pre>
   *
   * Constraints:
   * <ul>
   * <li>1 <= nums.length <= 10^4 </li>
   * <li>0 <= nums[i] <= 1000 </li>
   * <li>It's guaranteed that you can reach nums[n - 1]. </li>
   * </ul>
   *
   * <p>
   * @see <a href="https://leetcode.com/problems/jump-game-ii/solutions/3158169/clean-codes-full-explanation-implicit-bfs-c-java-python3">
   *     Explaination</a>
   * </p>
   * @param nums
   * @return
   */
  public int jump(int[] nums) {
    int ans = 0, end = 0, farthest = 0;

    for (int i = 0; i < nums.length; i++) {
      farthest = Math.max(farthest, i + nums[i]);
      if (farthest >= nums.length -1) {
        ans++;
        break;
      }

      if (i == end) {
        ans++;
        end = farthest;
      }
    }
    return ans;
  }

  /**
   * 274. H-Index
   * <pre>
   * Given an array of integers citations where citations[i] is the number of citations a
   * researcher received for their ith paper, return the researcher's h-index.
   *
   * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum
   * value of h such that the given researcher has published at least h papers that have each
   * been cited at least h times.
   *
   * Example 1:
   * Input: citations = [3,0,6,1,5]
   * Output: 3
   * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
   * received 3, 0, 6, 1, 5 citations respectively.
   * Since the researcher has 3 papers with at least 3 citations each and the remaining two with
   * no more than 3 citations each, their h-index is 3.
   *
   * Example 2:
   * Input: citations = [1,3,1]
   * Output: 1
   * </pre>
   *
   * Constraints:
   * <ul>
   * <li>n == citations.length </li>
   * <li>1 <= n <= 5000 </li>
   * <li>0 <= citations[i] <= 1000 </li>
   * </ul>
   *
   * <p>
   * @see <a href="https://leetcode.com/problems/h-index/solutions/70768/java-bucket-sort-o-n-solution-with-detail-explanation">
   *     Explained O(n) - Bucket Sort </a>
   * </p>
   * @param citations
   * @return
   */
  public int hIndex(int[] citations) {
    int n = citations.length;
    int[] buckets = new int[n+1];

    for(int c : citations) {
      if(c >= n) {
        buckets[n]++;
      } else {
        buckets[c]++;
      }
    }

    int count = 0;
    for(int i = n; i >= 0; i--) {
      count += buckets[i];
      if(count >= i) {
        return i;
      }
    }

    return 0;
  }
}
