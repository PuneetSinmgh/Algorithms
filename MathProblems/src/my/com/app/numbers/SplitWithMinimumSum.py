# https://leetcode.com/problems/split-with-minimum-sum/
#approach: Sort the digits and then split them into two numbers by taking alternate digits.
# Time complexity: O(nlogn) where n is the number of digits in the number
# Space complexity: O(n) for storing the digits in a list
# Note: This solution assumes that the input number is non-negative and does not contain leading zeros
# and that the input is a valid integer.
# If the input can have leading zeros or is not a valid integer, additional checks would be needed.

class Solution(object):
    def splitNum(self, num):
        """
        :type num: int
        :rtype: int
        """
        numAsList = [ int(d) for d in str(num)]
        numAsList.sort()
        i=0
        num1 , num2 = 0, 0
        while( i < len(numAsList)):
            if i%2==0:
                num1 = num1*10 + numAsList[i]
            else:
                num2 = num2*10 + numAsList[i]
            i+=1
        
        return num1+num2