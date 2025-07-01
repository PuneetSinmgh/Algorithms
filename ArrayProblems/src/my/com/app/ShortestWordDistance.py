from collections import defaultdict

class Solution(object):
    def shortestDistance(self, wordsDict, word1, word2):
        # this function finds the shortest distance between two words in a list of words.
        # another approach is to use a dictionary to store the indices of each word and then find the minimum distance between the two words.   
        # space complexity is O(n) and time complexity is O(n) where n is the length of the wordsDict.
        """
        :type wordsDict: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        
        indxDict = defaultdict(list)
        for i, s in enumerate(wordsDict):
            indxDict[s].append(i)
            
        l1 = indxDict[word1]
        l2 = indxDict[word2]

        i ,j = 0 , 0
        minDist = len(wordsDict)
        while i<len(l1) and j<len(l2):
            minDist = min( minDist , abs( l1[i] - l2[j]))
            if l1[i] < l2[j]:
                i+=1
            else:
                j+=1
        """

#         Given a list of words and two words, find the shortest distance between the two words in the list.
# this approachs useds constant space and O(n) time complexity
        p1, p2 = len(wordsDict), len(wordsDict)
        minDist = len(wordsDict)
        for i, s in enumerate(wordsDict):
            if s == word1:
                p1 = i
                minDist = min( minDist , abs( p1 - p2))
            elif s == word2:
                p2 = i
                minDist = min( minDist , abs( p1 - p2))
                
        return minDist
        