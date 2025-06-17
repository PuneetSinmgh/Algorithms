from collections import defaultdict 
class Solution(object):
    def tupleSameProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        hm = defaultdict(int)
        res =0
        
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                prod = nums[i]*nums[j]
                hm[prod] +=1 
        
        # now each product is mapped with the number of occurance
        # num of occurance means that many unique pairs , thus these pair can be combination of n pairs
        # comb(n) = (n*(n-1)) / 2 and since each combination internally has 8 permutations of unique digits
        for v in hm.values():
            res += 8 * (v*(v-1))/2
        return res
    
    