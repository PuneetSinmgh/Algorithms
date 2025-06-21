# https://leetcode.com/problems/gas-station/


class Solution(object):
    #cost of going from a ith gas station i+1 gas station has to be lesser than the gas in the tank.
    # this is cost is more than the gas in the station it can go to the next. 
    # so we can start from the statio which has +ve gas and keep going until the next positive. 
    # if we remain positive untill we complete the cycle
    
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        n = len(cost)
        costgains = [gas[i]-cost[i] for i in range(n)]
        
        totalSum = sum(costgains)
        res =0;
        currgain =0
        for i, c in enumerate(costgains):
            currgain += costgains[i]
            if currgain < 0:
                res = i+1
                currgain=0

        if totalSum >= 0:
            return res
        else:
            return -1; 
                
        

           