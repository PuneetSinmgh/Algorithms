package my.com.app;

import java.util.*;


class Node{
    
    boolean eop;
    int value;
    Map<String, Node> childs;

    public Node(){
        
        eop = false;
        value =0 ;
        childs = new HashMap<>();
    }
    
}


class DesignFileSystem {
    
    Node root;
    Map<String, Integer> hm; // Using a hashmap to store the paths and their values

    public DesignFileSystem() {
        root = new Node();  
        hm = new HashMap<String, Integer>();  
        hm.put("", -1);
    }
    
    public boolean createPath(String path, int value) {
        
        if ( hm.containsKey(path))
            return false;

        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);

        if ( !hm.containsKey(parent) || hm.containsKey(path))
            return false;

        hm.put(path, value);
        return true;
        //return addPath( path, value, root);
    }

    public boolean addPath( String path, int value, Node curr){ // using a trie structure
        //String[] paths = path.split("/");
        

        /*
        for ( int i=1 ; i< paths.length-1; i++ ){
            
            if ( !curr.childs.containsKey(paths[i])){
                return false;
            } else {
                curr = curr.childs.get(paths[i]);
            }

        }
        
        curr.childs.put(paths[paths.length-1], new Node() );
        curr = curr.childs.get(paths[paths.length-1]);

        curr.eop = true;
        curr.value = value;
        
        */

        hm.put(path, value);
        return true;
    }
    
    public int get(String path) {
        if ( hm.containsKey(path))
            return hm.get(path);
        
        return -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
