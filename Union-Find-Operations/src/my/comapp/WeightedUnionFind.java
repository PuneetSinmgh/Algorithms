package my.comapp;

public class WeightedUnionFind {

	
	private int arr[];
	private int size[];
	
	public WeightedUnionFind(int n) {
		
		arr = new int[n];
		size= new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=i;
			size[i]=1;
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
		
		if(size[p]<=size[q]) {
			arr[p]=q;
			size[q]= size[q]+size[p];
			
		}
		else {
			
			arr[q]=p;
			size[p]=size[p]+size[q];
		}
			
		
		System.out.println("connected components are\n");
		for(int i = 0 ; i<arr.length; i++)
			System.out.println(arr[i]);
		
		System.out.println("size of conected trees are\n");
		for(int i = 0 ; i<arr.length; i++)
			System.out.println(size[i]);
		
	}
	
	
	
}
