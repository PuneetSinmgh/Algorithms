# approach: Using a single queue to implement stack operations
# time complexity: O(n) for pop and top operations, O(1) for push
# space complexity: O(n) for storing the elements in the queue

class MyStack(object):

    def __init__(self):
        self.queue_st = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.queue_st.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        return self.queue_st.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.queue_st[-1]

    def empty(self):
        """
        :rtype: bool
        """
        return len(self.queue_st) == 0


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()