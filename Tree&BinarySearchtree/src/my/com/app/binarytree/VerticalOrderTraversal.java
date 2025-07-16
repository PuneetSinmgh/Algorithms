package my.com.app.binarytree ;


import java.util.*;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class VerticalOrderTraversal {

    int c ;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null)
            return new ArrayList();
    
        Map<TreeNode, Integer> hm = new LinkedHashMap();
        
        helper(hm,root,0);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Integer i : hm.values()){
            if(i<min){
                min=i;
            }
            if(i>max){
                max=i;
            }
        }
        
        int diff = 0-min;
        for(TreeNode n : hm.keySet()){
            hm.put(n,hm.get(n)+diff);
        }
        max = max+diff;
        List<List<Integer>> result = new ArrayList();
        
        int index ,i;
        for(TreeNode n :hm.keySet()){
           index = hm.get(n);
            if(result.size()<=index){
                i = index-result.size();
                while(i>=0){
                    result.add(new ArrayList());
                    i--;
                }
                result.get(index).add(n.val);
            }
            else{
                result.get(index).add(n.val);
            }
        }
        
     return result;
    }
    
    public void helper(Map<TreeNode, Integer> hm, TreeNode root, int col){
        
        if(root!=null){
            
            Deque<Pair<TreeNode,Integer>> que = new ArrayDeque();
            que.add(new Pair<TreeNode,Integer>(root,col));
            
            while(!que.isEmpty()){
                
                Pair<TreeNode,Integer> p = que.poll();
                    
                if(p.getKey()!=null){
                    hm.put(p.getKey(),p.getValue());    
                    que.add(new Pair<TreeNode,Integer>(p.getKey().left,p.getValue()-1));
                    que.add(new Pair<TreeNode,Integer>(p.getKey().right,p.getValue()+1));
                }
                
            }
            
            
        }
    }

    public class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
           
    }

}