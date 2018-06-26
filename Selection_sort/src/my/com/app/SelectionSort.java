package my.com.app;

public class SelectionSort {

	
	//private static Integer arr[];
	
	public static void main (String args[]) {
		
		 int arr[] = {22,343,445,546,232,65,3232,565,787,356};
		 int i,j,small;
		 System.out.println("array:\n");
		 for (i=0; i<10;i++) {
			 System.out.println(arr[i]);
		 }
		 
		 for (i =0 ;i<10;i++) {
			for (j=i+1;j<10;j++) {
				 if(arr[j]<arr[i]) {
					small = arr[j];
					arr[j]=arr[i];
					arr[i] = small;
				 }
			}
		 }
		 
		 System.out.println("sorted array:\n");
		 for (i=0; i<10;i++) {
			 System.out.println(arr[i]);
		 }
			 
	}
	
	
	
}
