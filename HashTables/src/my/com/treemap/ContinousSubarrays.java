package my.com.treemap;

import java.util.*;

// problem : Continuous Subarrays
// Given an array of integers, count the number of continuous subarrays such that the absolute difference
// between the maximum and minimum elements in the subarray is at most 2.
/*

You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:
Let i, i + 1, ..., j be the indices in the subarray. Then, for each pair of indices i <= i1, i2 <= j, 0 <= |nums[i1] - nums[i2]| <= 2.
Return the total number of continuous subarrays.
A subarray is a contiguous non-empty sequence of elements within an array.

Input: nums = [5,4,2,4]
Output: 8
Explanation: 
Continuous subarray of size 1: [5], [4], [2], [4].
Continuous subarray of size 2: [5,4], [4,2], [2,4].
Continuous subarray of size 3: [4,2,4].
There are no subarrys of size 4.
Total continuous subarrays = 4 + 3 + 1 = 8.
It can be shown that there are no more continuous subarrays.

*/

// Approach: Use a sliding window with a TreeMap to maintain the frequency of elements.
// The TreeMap will help us efficiently find the minimum and maximum elements in the current window.
// we can increase or decrease freq of max and min elements in the window.
// We will expand the right end of the window and contract the left end when the condition |nums[i] - nums[j]| > 2 is violated. 
// once the window is voilated, we will shrink the window from the left until the condition is satisfied again. i.e. until max or min changes
// For each valid window, we will count the number of subarrays that can be formed.


class Solution {
    public long continuousSubarrays(int[] nums) {
        
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int left = 0, right = 0;
        int n = nums.length;
        long count = 0;

        while (right < n) {
            // We want to keep the sliding window sorted
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // While window violates the condition |nums[i] - nums[j]| ≤ 2
            // Shrink window from left
            while (freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2) {
                // Remove leftmost element from frequency map
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }

            // Add count of all valid subarrays ending at right
            count += right - left + 1;
            right++;
        }

        return count;
    }
}