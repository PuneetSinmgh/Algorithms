package src.my.com.hashmap;
import java.util.*;

// Logger class to implement rate limiting for log messages
// The logger should print a message if it has not been printed in the last 10 seconds
// If a message is printed, it should not be printed again for the next 10 seconds

class Logger {

    HashMap<String , Integer> hm;
    
    public Logger() {
        hm = new HashMap();    
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if ( hm.containsKey(message)){
            if ( timestamp < hm.get(message)){
                return false;
            } else {
                
                hm.put( message, timestamp + 10);
                return true;
                
            }
        } else {
            hm.put( message, timestamp + 10);
            return true;
        }
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */