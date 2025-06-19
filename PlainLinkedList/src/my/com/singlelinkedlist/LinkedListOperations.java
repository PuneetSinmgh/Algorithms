package my.com.app;

import java.util.Hashtable;

public class LinkedListOperations {

	public Node remduplicates(Node head) {
		
		Hashtable<Integer, Integer> ht = new Hashtable();
		
		Node p1 = head;
		if(p1==null || p1.next == null) {
			return null;
		}
		while(p1.next!=null) {
			
			if(ht.containsKey(p1.next.data)) {
					Node temp = p1.next;
					p1.next = temp.next;
					temp.next = null;
					return temp;
				
			}else {
				ht.put(p1.next.data,1 );
			}
			
			p1 = p1.next;
		}
		return null;
	}
	
	public Node addTwoNumbers(Node l1 , Node l2) {
        if(l1 == null ){
            return l2;
        }     
        if( l2 == null)
            return l1;
        
        if(l1==null && l2==null)
            return null;
        
        int sum =0 , bor =0 , rem =0 , q =0;
        Node l3 = null , head = null;
        while(l1!= null || l2!= null){

            if(l1== null){
                sum = 0 + l2.data + bor;
            }
            else if(l2== null){
                sum = l1.data + 0 + bor;
            }
            
            else{
                sum = l1.data + l2.data + bor;
            }
            bor=0;
            if(sum >= 10){
                rem = sum%10;
                q = sum/10;
                Node n = new Node(rem);
                bor = q;
                if(l3==null){
                    l3 = n;
                    head = n;   
                }
                else{
                    l3.next = n;
                    l3 = l3.next;
                }
            }
            else{
                Node n = new Node(sum);
                if(l3==null){
                    l3 = n;
                    head = n;   
                }
                else{
                    l3.next = n;
                    l3 = l3.next;        
                }
            }
            l1 = l1!=null? l1.next : null;
            l2 = l2!=null? l2.next : null;
        }
        if(bor>0){
            l3.next = new Node(bor); 
        }
    return head;
	}	
	
	public Node intersection(Node A, Node B) {
	
		if(A == null || B==null)
			return null;
		
		Node l1 = A;
		Node l2 = B,temp;
		int i =0 , j=0;
		while(l1!=null) {
			i++;
			l1= l1.next;
		}
		
		while(l2!=null) {
			j++;
			l2 = l2.next;
		}
		int dif = (i>j)?i-j:j-i;
		Node l3 = A;
		Node l4 = B;
		if(i>j) {
			while(dif!=0) {
				l3 = l3.next;
				dif--;
			}
		}
		else {
			while(dif!=0) {
				l4 = l4.next;
				dif--;
			}
		}
		while(l3!=null && l4!=null) {
			if(l3==l4) {
				temp = l3;
				return temp;
			}
			l3 = l3.next;
			l4= l4.next;
		}
		return null;
	}
}
