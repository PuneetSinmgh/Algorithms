class Solution(object):
    def removeAlmostEqualCharacters(self, word):
        """
        :type word: str
        :rtype: int
        """
        i = 1
        count=0
        while i < len(word):
            
            c2 = ord(word[i])
            c1 = ord(word[i-1])
            
            if c1 == c2 or abs(c1-c2)==1:
                count+=1 
                i+=2
            else:
                i+=1
                continue
    
        return count