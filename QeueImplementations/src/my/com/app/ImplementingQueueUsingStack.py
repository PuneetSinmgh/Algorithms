
# approach: Use two stacks, one for pushing and one for popping 
# check for pop and peek if the pop stack is empty, if it is then fill it with the push stack
# Time complexity: O(1) for push, pop and peek operations on average, O(n) for filling the pop stack
# Space complexity: O(n) for storing the elements in the stacks


class MyQueue(object):

    def __init__(self):
        self.pushSt = []
        self.popSt = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.pushSt.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        if len(self.popSt) == 0:
            self.fillPopSt()
        
        return self.popSt.pop()

    def peek(self):
        """
        :rtype: int
        """
        if len(self.popSt) == 0:
            self.fillPopSt()
        
        return self.popSt[-1]

    def fillPopSt(self):
        for i in  range(len(self.pushSt)):
            self.popSt.append( self.pushSt.pop() )
    
    def empty(self):
        """
        :rtype: bool
        """
        return len(self.pushSt) == 0 and len(self.popSt) == 0 


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()