package my.comapp;

public class QuickUnionFind {

	private int arr[];
	
	public QuickUnionFind(int n) {
		
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=i;
		}
	}
	
	Boolean isConected(int p,int q) {   // if root if two element are same the elements are in same connected component 
		
		while(arr[p]!=p)
			p=arr[p];
		
		while(arr[q]!=q)
			q=arr[q];
		
		if(arr[p]==arr[q])
			return true;
		else
			return false;

	}
	
	void union(int p, int q) {   // compares root of two element , element with same root are in same connected component 
		
		while(arr[p]!=p)
			p = arr[p];
		
		while(arr[q]!=q)
			q= arr[q];
		
		if(p!=q)
			arr[p]=q;
		else
			System.out.println("already in connected component");
		
		System.out.println("connected components are\n");
		for(int i = 0 ; i<arr.length; i++)
			System.out.println(arr[i]);
		
	}
	
}
