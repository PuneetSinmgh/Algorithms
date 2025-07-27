package my.com.hashmap;

import java.util.HashMap;
import java.util.Map;

public class BankSystem {

   

    Map<Integer, Long> accounts;

    public BankSystem(long[] balance) {
        accounts = new HashMap<>();    
        for( int i=0; i < balance.length; i++ ){
            accounts.put(i+1 , balance[i]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {

       if ( withdraw(account1, money) ){
            if ( deposit( account2, money) ) {
                return true;
            }
            else{
                deposit( account1, money);
                return false;
            }
                    
        } else {
            return false;
        }
    
    }
    
    public boolean deposit(int account, long money) {
        
        if ( accounts.containsKey(account)){
        
            long bal = accounts.get(account);
            
            accounts.put(account, bal + money );
            return true;    
        }

        return false;
    }
    
    public boolean withdraw(int account, long money) {
        
        if ( accounts.containsKey(account)){
            long bal = accounts.get(account);
            if (money <= bal ){
                accounts.put(account, bal - money );
                return true;
            }
        }

        return false;
    }
    public long getBalance(int account) {
        
        if ( accounts.containsKey(account)){
            return accounts.get(account);
        }

        return -1;
    }
    public boolean isValidAccount(int account) {
        return accounts.containsKey(account);
    }

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
}
