class Solution(object):
    def numSubarrayProductLessThanK(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        #  iterate over nums with two pointers i and j and for each subarray product less than k 
        # increment i product is greater than j , if i reaches j then increment j keep incrementing until product is equal or more than k

        #Brute force : O(n^2) time and O(n) space
        '''
        i=0
        j=0
        res =0
        prod = [1]
        for j in range(0, len(nums)):
            
            prod.append(prod[-1] * nums[j])

        j = len(prod)-1
        while j > 0:

            if prod[j] < k:
                res +=1
            
            i = j-1
            while i > 0 :
                if prod[j]//prod[i] < k:
                    res +=1
                i-=1

            j-=1
        '''
        # valid subarray from i to j = j- i +1 : O(n) time and O(1) space
        if k <= 1:
            return 0
        
        i=0
        j=0
        res =0
        prod = 1
        for j in range(len(nums)):

            prod *= nums [j]

            while prod >= k:  # dividing prod becomes less than k
                prod //= nums[i]
                i+=1

            res += j-i+1
        return res
            
        