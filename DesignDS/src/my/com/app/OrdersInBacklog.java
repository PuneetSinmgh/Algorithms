package my.com.app;
import java.util.*;
// This class is a placeholder for the OrdersInBacklog functionality.


class Order{
    int price;
    int qty;

    public Order(int p , int q){
        this.price = p;
        this.qty = q;
    }
}

public class OrdersInBacklog {
    
     public int getNumberOfBacklogOrders(int[][] orders) {

        PriorityQueue<Order> buyMaxHeap = new PriorityQueue<>((a,b) -> b.price - a.price);  

        PriorityQueue<Order> sellMinHeap = new PriorityQueue<>((a,b) -> a.price - b.price);

        for ( int[] arr : orders){

            if ( arr[2] == 0){ // buy

                if ( sellMinHeap.isEmpty() || ( sellMinHeap.peek()!=null && sellMinHeap.peek().price>arr[0])){
                    buyMaxHeap.add( new Order( arr[0], arr[1] ));
                    continue;
                }
                
                int orderQty = arr[1];
                while( !sellMinHeap.isEmpty() && orderQty>0){
                    Order minSellOrder = sellMinHeap.peek();
                    if ( minSellOrder.price <= arr[0]) {
                        if ( minSellOrder.qty <= orderQty){
                            orderQty -= minSellOrder.qty;
                            sellMinHeap.poll();
                        } else {
                            minSellOrder.qty -= orderQty;
                            orderQty = 0;
                        }
                    } else {
                        buyMaxHeap.add( new Order( arr[0], orderQty ));
                    }
                }

                if ( orderQty>0){
                    buyMaxHeap.add( new Order( arr[0], orderQty ));
                }

            } else { // sell

                if ( buyMaxHeap.isEmpty() || ( buyMaxHeap.peek()!=null && buyMaxHeap.peek().price < arr[0])){
                    sellMinHeap.add( new Order( arr[0], arr[1] ));
                    continue;
                }
                
                int orderQty = arr[1];

                while( !buyMaxHeap.isEmpty() && orderQty>0){
                
                    Order maxBuyOrder = buyMaxHeap.peek();
                    
                    if ( maxBuyOrder.price >= arr[0]) { // if buy price is higher then we match and execute
                        
                        if ( maxBuyOrder.qty <= orderQty){
                            orderQty -= maxBuyOrder.qty;
                            buyMaxHeap.poll();
                        } else {
                            maxBuyOrder.qty -= orderQty;
                            orderQty = 0;
                        }

                    } else {
                        sellMinHeap.add( new Order( arr[0], orderQty ));
                    }
                }

                if ( orderQty>0){
                    sellMinHeap.add( new Order( arr[0], orderQty ));
                }

            }

        }

        // once all order processed count remaing orders
        int res = 0, mod = 1000000007;
        
        while (  !buyMaxHeap.isEmpty() ){
            res += (res + buyMaxHeap.poll().qty) % mod;
        }

        while ( !sellMinHeap.isEmpty() ){
            res += (res + sellMinHeap.poll().qty) % mod;
        }

        return res ;
    
    
    }

     public int ordersInBacklog(int[][] orders) {

        PriorityQueue<int[]> buyMaxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0] );  

        PriorityQueue<int[]> sellMinHeap = new PriorityQueue<>((a,b) -> a[0] - b[0] );

        for ( int[] arr : orders){

            
            if (arr[2] == 0)
                buyMaxHeap.offer(arr);
            else
                sellMinHeap.offer(arr);

            while (!buyMaxHeap.isEmpty() && !sellMinHeap.isEmpty() && sellMinHeap.peek()[0] <= buyMaxHeap.peek()[0]) {
                
                int k = Math.min(buyMaxHeap.peek()[1], sellMinHeap.peek()[1]);
                buyMaxHeap.peek()[1] -= k;
                sellMinHeap.peek()[1] -= k;
                if (buyMaxHeap.peek()[1] == 0) buyMaxHeap.poll();
                if (sellMinHeap.peek()[1] == 0) sellMinHeap.poll();
            
            }

        }

        // once all order processed count remaing orders
        int res = 0, mod = 1000000007;
        
        for (int[] o : sellMinHeap)
            res = (res + o[1]) % mod;
        for (int[] o : buyMaxHeap)
            res = (res + o[1]) % mod;

        return res ;
    }

    
}
