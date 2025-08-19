package my.com.app;

import java.util.*;


// Problmem: Design an in-memory file system that supports creating directories, adding files, and reading file contents.

// Approach: Use a tree structure to represent the file system.
// Each node can represent either a file or a directory. Directories can contain other directories or
// files, while files contain content. We can use a map to store the children of each directory.
// The root node represents the root directory of the file system.  
// Each file will have a name and content, while directories will have a name and a map of subdirectories.

// runtime: O(n) for creating directories and files, O(m) for reading file content where n is the number of directories/files and m is the length of the content.
// space: O(n) for storing the file system structure.

class Node{
    boolean isFile;
    boolean isDirectory;
    String fileContent;
    Map<String, Node> subDir;

    Node(){
        isFile = false;
        isDirectory = false;
        fileContent = "";
        subDir = new TreeMap<>();
    }
}

public class DesignInMemFileSystem {
    
     Node root; // follow path as root 
    public DesignInMemFileSystem() {
        root = new Node();
        root.isDirectory = true;
    }
    
    public List<String> ls(String path) {
        if ( path.equals("/"))
            return root.subDir.keySet().stream().toList();

        Node curr = root;
        path = path.substring(1);
        String[] pathnames = path.split("/");
        
        curr = getNode(pathnames, curr);
        
        if ( curr.isFile ){
            return Arrays.asList(pathnames[pathnames.length-1]);
        }

        if ( curr.isDirectory){
            return curr.subDir.keySet().stream().toList();
        }
        return Arrays.asList();
    }
    
    public void mkdir(String path) {
        addDir(path.substring(1), root);
    }
    public void addDir( String path, Node curr){

        String[] pathnames = path.split("/");
        for ( String n : pathnames){
            if ( !curr.subDir.containsKey(n)){
                curr.subDir.put( n, new Node());
            }
            curr = curr.subDir.get(n);
            curr.isDirectory = true;
        }
    }

    public Node getNode(String[] pathnames, Node curr ){
        for ( String n : pathnames){
            curr = curr.subDir.get(n);
        }
        return curr;
    }
    
    public void addContentToFile(String filePath, String content) {
        
        
        int idx = filePath.lastIndexOf("/");
        String fileName = filePath.substring( idx+1 );
        String[] pathnames ;
        if ( idx != 0){
            filePath = filePath.substring(1, idx);
            pathnames = filePath.split("/");
        } else {
            filePath = "";
            pathnames = new String[0];
        }
        
        Node curr = getNode(pathnames, root);
        
        if ( !curr.subDir.containsKey(fileName) ){
            curr.subDir.put( fileName, new Node());
        }
        
        curr = curr.subDir.get(fileName);
        curr.isFile = true;
        curr.fileContent += content;
        
    }
    
    public String readContentFromFile(String path) {
        path = path.substring(1);
        String[] pathnames = path.split("/");
        
        Node curr = getNode(pathnames, root);
        
        return curr.fileContent;
        
    }
}
