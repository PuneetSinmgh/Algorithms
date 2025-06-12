class Bank(object):

    bank_dic = {}
    
    def __init__(self, balance):
        """
        :type balance: List[int]
        """
        for i , bal in enumerate(balance):
            self.bank_dic[i+1] = bal
        
        
        

    def transfer(self, account1, account2, money):
        """
        :type account1: int
        :type account2: int
        :type money: int
        :rtype: bool
        """
        if account1 in self.bank_dic is not None and account2 in self.bank_dic is not None:
            if self.withdraw(account1, money):
                if self.deposit( account2, money):
                    return True
                else:
                    self.deposit( account1, money)
                    return False
            else:
                return False
        
        return False

        

    def deposit(self, account, money):
        """
        :type account: int
        :type money: int
        :rtype: bool
        """
        if account in self.bank_dic is not None:
            self.bank_dic[account] += money
            return True
        
        return False

    def withdraw(self, account, money):
        """
        :type account: int
        :type money: int
        :rtype: bool
        """
        if account in self.bank_dic is not None and self.bank_dic[account] >= money:
            self.bank_dic[account] -= money
            return True
        
        return  False
        


# Your Bank object will be instantiated and called as such:
# obj = Bank(balance)
# param_1 = obj.transfer(account1,account2,money)
# param_2 = obj.deposit(account,money)
# param_3 = obj.withdraw(account,money)