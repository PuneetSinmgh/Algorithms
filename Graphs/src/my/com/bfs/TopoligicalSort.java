class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         
        int[] inorder = new int[numCourses];
        
        Arrays.fill(inorder, 0);
        int[] res = new int[numCourses];
        
        // boolean[] visited = new boolean[numCourses];
        //Arrays.fill(visited, false);
        
        HashMap<Integer, List<Integer>> hm = new HashMap();
        
        for (int i =0 ; i<numCourses ; i++){
            hm.put( i,  new ArrayList() ); 
        }
       
        for ( int[] arr : prerequisites) {  
            hm.computeIfAbsent( arr[1], k -> new ArrayList() ).add(arr[0]); 
            inorder[arr[0]] +=1;
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque();
        
        for (int i =0 ; i<numCourses ; i++){
            if ( inorder[i] == 0)
                queue.add(i);
        }
        int count = 0;
        
        while(!queue.isEmpty()){
            
            int s = queue.poll();
            res[count++] = s;
            
                
            List<Integer> dep = hm.get(s);
            for ( int d : dep ){
                inorder[d] -= 1;

                if ( inorder[d] == 0)
                    queue.add(d);
            }            
        }
            
       if(count == numCourses)
            return res;    
        else
           return new int[0];
    }
}