import collections
from collections import defaultdict
# https://binarysearch.com/problems/Closest-Element-Queries
# approach : create a map of value to index list, then for each query find index in the list. And then the closest query value index from the list
# time complexity : O(n + qlogn) where n is the length of nums and q is the length of queries

class Solution(object):
    '''
    def solveQueries(self, nums, queries):
        """
        :type nums: List[int]
        :type queries: List[int]
        :rtype: List[int]
        """

        map=defaultdict(list) ; res = []
        for i , val in enumerate(nums):
            map[val].append(i)
        
        for i in range(len(queries)):
            target = nums[queries[i]]
            tidx = queries[i]
            l = map.get(target)
            l.remove(tidx)
            j = self.searchIdx( l, tidx, len(nums)-1, 0 , len(l)-1) # j is minimum distance between  tidx and other index in list l
            res.insert(i , j)
            l.append(tidx) # find another way add and remove
            l.sort()
            map[target] = l
        
        return res
    
    def searchIdx(self, l, idx , numlen, s, e):
        if ( s > e):
            return -1
        
        mid = s + (e -s)/2
        if l[mid] < idx:
            # check if it is last index
            if mid == len(l)-1:
                return min( idx-l[mid], (numlen -idx) +(l[0]+1))

            if l[mid+1] < idx:
                return  self.searchIdx( l, idx, numlen , mid+1 , e)
            else:
                return min( idx-l[mid], l[mid+1]-idx)
        elif l[mid] > idx:
            if mid == 0: # corner case for idx lexx than last index
                return min(l[mid]-idx , (idx+1)+ numlen - l[len(l)-1] )
            if l[mid-1] > idx:
                return  self.searchIdx( l, idx, numlen , s , mid-1)
            else:
                return min( idx-l[mid-1], l[mid]-idx )
             
'''
    def solveQueries(self, nums, queries):

        map= defaultdict(list)
        res = []
        for i , val in enumerate(nums):
            map[val].append(i)
        
        for i in range(len(queries)):
            l = map.get(nums[queries[i]])
            if len(l) == 1:
                res.insert(i, -1)
                continue

            q = queries[i]
            numlen = len(nums)
            qIdx = self.searchIdx( q, l, 0 , len(l)-1) # qIdx is index of queries[i] in list l
            
            # find the closest index of queries[i] in list l
            
            if qIdx == 0:
                minD = min( l[qIdx+1] - l[qIdx] , numlen - l[-1] + l[qIdx] )
            
            elif qIdx == len(l)-1:

                minD = min( l[qIdx] - l[qIdx-1] , numlen - l[qIdx] + l[0] )

            else:
                minD = min( l[qIdx+1] - l[qIdx] , l[qIdx] - l[qIdx-1] )
            
            res.insert(i, minD)
            
        return res

    def searchIdx(self, val, l , s, e):
        
        while s<=e:
            mid = s+ (e-s)/2
            if l[mid] < val:
                s = mid+1
            elif l[mid] > val:
                e = mid-1
            else:
                return mid
    
