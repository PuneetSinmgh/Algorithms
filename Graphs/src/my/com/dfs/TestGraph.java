package my.com.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestGraph {

	public static void main(String args[]) {
		
		
		InputStreamReader in = new InputStreamReader(System.in);
		 BufferedReader br = new BufferedReader(in);
		Scanner sc = new Scanner(System.in);
		 //ArrayImplementationStack stack = new ArrayImplementationStack();
		 
		 Graph gh = new Graph();
		 int  idx1 , idx2 , data, numvertices;
		 String line = null;
		 try {
		
			 System.out.println("enter number of vertices:");
			 line = br.readLine();
			 System.out.println("enter vertices:");
			 numvertices = Integer.parseInt(line);
			 	for (int i=0;i<numvertices; i++) {
					
					data = sc.nextInt();
					gh.addvertices(i, data);
					
				}
			 	
			 	System.out.println("enter number of edges:");
				String noofedegs = br.readLine();
				int num = Integer.parseInt(noofedegs);
				System.out.println("enter vertices:");
				for (int i=0;i<num; i++) {
					
					idx1 = sc.nextInt();
					idx2 = sc.nextInt();
					gh.addEdge(gh.allvertices.get(idx1), gh.allvertices.get(idx2));
					
				}	
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		Vertex source = gh.allvertices.get(0);
		
		 System.out.println("bfs:" );
		 //gh.bfs(source);
		 System.out.println("dfs");
		 gh.dfs(source);
		 
	}
}
