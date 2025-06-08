class Solution(object):
    def maxFreq(self, s, maxLetters, minSize, maxSize):
        """
        :type s: str
        :type maxLetters: int
        :type minSize: int
        :type maxSize: int
        :rtype: int
       
        #Brute force 
        
        j=0
        lset = set()
        dic = defaultdict(int)
        for i in range(len(s)-minSize+1):
            
            j=i+minSize
            subStr = s[ i : j ]

            if ( len(set(subStr)) > maxLetters):
                continue
            
            dic[subStr] += 1

            while j<len(s) and j-i <= maxSize-1: #check until axSize is met
                
                lset.add(s[j] )
                if ( len(lset) > maxLetters):
                    lset.remove( s[j])
                    break
                subStr += s[j]
                dic[subStr] += 1
                j+=1
        
        if len(dic) == 0:
            return 0
        return  max(dic.values()) 
         """
        # Optimized : approach : # Use sliding window to get all substrings of size minSize and check if it has maxLetters
        # and then use a dictionary to count the frequency of each substring.
        # This approach is more efficient than the brute force method as it avoids unnecessary checks and uses a single pass to count frequencies.
        # Time complexity: O(n) where n is the length of the string s.
        # Space complexity: O(n) for the dictionary to store substring frequencies.
        from collections import defaultdict

        dic = defaultdict(int)
        for i in range(len(s)-minSize+1):
            j=i+minSize
            subStr = s[ i : j ]

            if ( len(set(subStr)) > maxLetters):
                continue
            
            dic[subStr] += 1
            
        if len(dic) == 0:
            return 0
        
        return  max(dic.values())
            

                

