
from collections import Counter, defaultdict

#approach : use sliding window to find the minimum substring that contains all characters of t in s 
# and use a dictionary to count the frequency of characters in t and the current substring. Compare the counts to determine if the current substring contains all characters of t.
# Time complexity: O(n) + O(m) where n is the length of s and Mis length of t 

class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        dic_t = Counter(t) # get the count of elements of t

        curr_dic = defaultdict(int)

        l , r = 0 ,0
        uniqueChar = 0
        m  = len(s)+len(t)+1
        ans =  m , None, None
        while r< len(s):

            char = s[r]
            curr_dic[char] += 1

            if char in dic_t and dic_t[char] == curr_dic[char]: # checking count for each char and if equal to char count in t then increment uniqueCharCount
                uniqueChar+=1
            
            # if current substring contains all desired element, then keep reduce i and check for min length desired string
            while l <= r and uniqueChar == len(dic_t):
                lchar = s[l]
                # check minimum size of subtring
                if  r-l+1 < ans[0] :
                    ans = ( r-l+1 , l , r) # update with minimum value
                curr_dic[lchar] -= 1
                if lchar in dic_t and dic_t[lchar] > curr_dic[lchar]: # check to see if removed char is from t
                    uniqueChar-=1
                l+=1

            r+=1
        if ans[0] == m:
            return ""

        return s[ ans[1]: ans[2]+1 ]