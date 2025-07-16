package my.com.sorting;

import java.util.*;

class Solution {
    public int[] sortArray(int[] nums) {
        
        int start=0 ;
        int end = nums.length-1;
        int[] tempArr = new int[nums.length];
        breakAndMergeSort(nums, start, end, tempArr);
        return nums;
    }
    
    public void breakAndMergeSort(int[] nums, int start, int end, int[] tempArr){
        
        if ( start == end )
            return;
        
        int mid = start + (end-start)/2;
        
        breakAndMergeSort(nums, start, mid, tempArr);
        breakAndMergeSort(nums, mid+1, end, tempArr);
        merge(nums, start, mid, end, tempArr);
        
    } 
    
    public void merge(int[] arr, int left, int mid, int right, int[] tempArr){
        
        int start1 = left;
        int start2 = mid + 1;
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        for (int i = 0; i < n1; i++) {
            tempArr[start1 + i] = arr[start1 + i];
        }
        for (int i = 0; i < n2; i++) {
            tempArr[start2 + i] = arr[start2 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (tempArr[start1 + i] <= tempArr[start2 + j]) {
                arr[k] = tempArr[start1 + i];
                i += 1;
            } else {
                arr[k] = tempArr[start2 + j];
                j += 1;
            }
            k += 1;
        }

        while (i < n1) {
            arr[k] = tempArr[start1 + i];
            i += 1;
            k += 1;
        }
        while (j < n2) {
            arr[k] = tempArr[start2 + j];
            j += 1;
            k += 1;
        }
    }
}