package dev.leetcode;

/**
 * Leetcode problems of 'Top Interview 150' category.
 */
public class Interview150 {

    /**
     * 88. Merge Sorted Array
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
     * <ul>
     * <li> nums1.length == m + n </li>
     * <li> nums2.length == n </li>
     * <li> 0 <= m, n <= 200 </li>
     * <li> 1 <= m + n <= 200 </li>
     * <li> -10^9 <= nums1[i], nums2[j] <= 10^9 </li>
     * </ul>
     *
     * <p>Follow up: Can you come up with an algorithm that runs in O(m + n) time? </p>
     *
     * @param nums1
     *          - array of integers in ascending order
     * @param m
     *          - valid number of elements in <code>nums1</code>
     * @param nums2
     *          - array of integers in ascending order
     * @param n
     *          - valid number of elements in <code>nums2</code>
     *
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
     * <ul>
     * <li> 0 <= nums.length <= 100 </li>
     * <li> 0 <= nums[i] <= 50 </li>
     * <li> 0 <= val <= 100 </li>
     * </ul>
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        return -1;
    }


}
