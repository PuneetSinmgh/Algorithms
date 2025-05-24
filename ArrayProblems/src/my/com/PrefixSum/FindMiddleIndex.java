package my.com.prefixsum;
import java.util.*;

public class FindMiddleIndex {

    public static void main(String[] args) {
        // Test the findMiddleIndex method
        FindMiddleIndex fmi = new FindMiddleIndex();
        int[] nums1 = {2, 3, -1, 8, 4};
        System.out.println(fmi.findMiddleIndex(nums1)); // Output: 3

        // Test the pivotIndex method 
        int[] nums2 = {1, 7, 3, 6, 5, 6};
        System.out.println(fmi.pivotIndex(nums2)); // Output: 3
    }

    // Find middle index of an array where sum of left side is equal to sum of right side
    // using prefix sum 
    public int findMiddleIndex(int[] nums) {
        int[] sum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sum[i] = (i == 0) ? nums[i] : nums[i] + sum[i - 1];
        }

        int len = sum.length;

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (sum[len - 1] - sum[i] == 0)
                    return i;
            } else {
                if (sum[i - 1] == sum[len - 1] - sum[i]) {
                    return i;
                }

                if ((i == len - 1) && sum[len - 2] == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Find middle index of an array where sum of left side is equal to sum of right side
    // Find Pivot Index
    // without using prefix sum
    public int pivotIndex(int[] nums) {
        int i, j, suml = 0, sumr = 0, k = 0, pivot[] = new int[nums.length];
        for (i = 0; i < nums.length; i++)
            suml = suml + nums[i];

        sumr = 0;

        for (j = 0; j < nums.length; j++) {

            if ((suml - nums[j]) == sumr)
                return j;

            suml = suml - nums[j];
            sumr = sumr + nums[j];
        }
        return -1;
    }
}