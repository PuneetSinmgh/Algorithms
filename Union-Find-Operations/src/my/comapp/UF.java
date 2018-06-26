package my.comapp;

public class UF {

	private int arr[];
	
	UF(int n){
		arr = new int[n];
		for (int i=0;i<n;i++) {
			arr[i]= i;
		
		}
	}
	
	Boolean connected(int p ,int q) {
		
		if (arr[p]!= arr[q])
			return false;
		else
			return true;
	}
	
	void union(int p, int q) {
		
		int x = arr[p];
		int y = arr[q];
		
		if(connected(p,q)) {
			System.out.println("int same connected component");
		}
		else {
			for (int i =0; i<arr.length;i++) {
				if (arr[i]==y)
					arr[i]= x;
			}
		}
		
		System.out.println("connected components are\n");
		for(int i = 0 ; i<arr.length; i++)
			System.out.println(arr[i]);
	}
	
}
 