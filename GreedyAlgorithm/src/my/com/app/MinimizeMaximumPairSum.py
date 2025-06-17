class Solution(object):
    def minPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        i ,j  = 0, len(nums) -1 
        sum =0
        while i<j:
            sum = max(sum , nums[i]+ nums[j])
            i+=1
            j-=1

        return sum 