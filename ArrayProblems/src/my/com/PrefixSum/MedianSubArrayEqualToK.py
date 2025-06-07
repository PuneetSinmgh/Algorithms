class Solution(object):
    def countSubarraysBruteForce(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
    # Brute force might not work wiht large data set
        count=0
        n = len(nums)
        for i in range(n):
            for j in range( i , n ):
                arr = nums[i : j+1]
                arr.sort()
                m = 0 + (( j-i)//2)
                if ( arr[m] == k):
                    count+=1
        
        return count
