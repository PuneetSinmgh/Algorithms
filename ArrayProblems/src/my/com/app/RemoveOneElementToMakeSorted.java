package my.com.app;

// Approach: Iterate through the array from the end to the beginning.
// If we find a pair of elements where the current element is not greater than the previous one, we have two options:
// 1. Remove the current element and check if the rest of the array is strictly increasing.
// 2. Remove the previous element and check if the rest of the array is strictly increasing.
// We can use a boolean flag to track if we have already removed an element.
// If we find a second pair that violates the strictly increasing condition after removing one element, we return false.

class Solution {
    public boolean canBeIncreasing(int[] nums) {
         
        int i = nums.length-1;
        boolean removed = false ;
        while ( i>0 ){

            if ( nums[i] > nums[i-1]){
                i--;
            } else {
                if ( removed ){
                    return false;
                }else { // first encounter
                    removed = true;
                    if ( i>1 && nums[i] > nums[i-2] )
                        i-=2;
                    else{
                        if ( i==1 && nums[i] <= nums[i-1]){
                            return true;
                        }

                        if ( i == nums.length-1 ){
                            if (nums[i-1] >= nums[i-2]){
                                i-=1;
                                continue;
                            } else {
                                return false;
                            }
                        }

                        if ( nums[i+1] > nums[i-1] ){
                            i-=1;
                            continue;
                        }

                        return false;
                    }
                        
                }
            }
        }

        return true;
    }
}