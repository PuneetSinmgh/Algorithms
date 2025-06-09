class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        sub = str()
        num=0
        stack = []
        for i in range(len(s)):

            if s[i].isdigit():
                num = 10*num + int(s[i])
            else:
                if s[i] == '[':
                    # push a tuple of sub string and current number
                    stack.append( (num, sub))
                    sub = str()
                    num = 0
                elif s[i] == ']':
                    t = stack.pop()
                    sub = t[1] + (t[0] * sub)
                    num = 0
                else:
                    sub+= s[i]
        
        return sub
        
        

             