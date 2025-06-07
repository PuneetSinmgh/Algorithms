class Solution(object):
    def compress(self, chars):
        """
        :type chars: List[str]
        :rtype: int
        """
        # Iterate over the array, using a reader and writter pointer. 
        # if group is more than 1 then next post for writer will include the length of the group
        # reader reads and if a new element is encountered than the prev then publish old count and insert new char

        i, j = 0, 0
        prev = chars[j]
        count =0
        while j < len(chars):

            if chars[j] != prev:    
                if count >1:
                    digits = self.getDigits(count)
                    for d in digits:
                        i+=1
                        chars[i] = str(d)
                #else:
                   # i+=1        
                
                prev = chars[j]
                i+=1
                chars[i] = prev
                count=1
            else:
                count+=1
            j+=1
        
        if count >1:
            digits = self.getDigits(count)
            for d in digits:
                i+=1
                chars[i] = str(d)

        return i+1

    def getDigits(self, num):
        digits=[]
        while num >0:
            d = num %10
            digits.append(d)
            num //=10
        digits.reverse()
        return digits    
        