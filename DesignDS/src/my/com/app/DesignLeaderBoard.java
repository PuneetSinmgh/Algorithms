package my.com.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

class Player{
    int playerId;
    int score;

    Player(int id, int s){
        playerId = id;
        score = s;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player order = (Player) o;
        return playerId == order.playerId;
    }

    public int hashCode() {
        return Objects.hash(playerId);
    }

   
}
public class DesignLeaderBoard {
    //Set<Player> lb;
    Map<Integer, Player> hm;

    public DesignLeaderBoard() {
        //lb = new TreeSet<>( (a,b) -> b.score - a.score );    
        hm = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {

        Player p = hm.getOrDefault( playerId,  new Player( playerId, 0 ));

        p.score += score;
                //lb.add(p);
        hm.put( playerId, p );
    }
    
    public int top(int K) {
        int sum =0 ;

        PriorityQueue<Player> pq = new PriorityQueue<>( (a,b) -> b.score - a.score);
        
        hm.values().stream().forEach(x -> pq.add(x));

        while( K > 0 && !pq.isEmpty()){
            sum+= pq.poll().score;
            K--;
        }
        return sum;
    }
    
    public void reset(int playerId) {
        Player p = hm.get(playerId);
        
        //lb.remove( p );
        
        p.score = 0;
        
        //lb.add(p);
        hm.put(playerId, p);
    }
}
