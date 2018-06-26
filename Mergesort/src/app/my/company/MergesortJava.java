package app.my.company;

import java.util.Random;

public class MergesortJava {

	private static int [] arr = new int[50];
	
	
	
	public static void main(String[] args) {
		
		int i, left , right;
		Random rand = new Random();
		
		for (i=0;i<50;i++) {
		arr[i]= rand.nextInt(100);	
		}
		
	
		for (i=0;i<50;i++) {
			System.out.println(arr[i]);	
		}
		
		left = 0;
		right = arr.length-1;
		mergesort(arr,left,right);
		
		System.out.println("\nsorted array:");
		for (i=0;i<50;i++) {
			System.out.println(arr[i]+",");	
			}
	}
	
	private static int mergesort(int arr[], int start , int end ) {
		if(start<end) {
			int mid= (end+start)/2;
			//System.out.println("\nmid:"+mid);
			mergesort(arr, start,mid);
			mergesort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
		
		return 0;
	}

	private static int merge(int arr[] , int l, int m, int r) {
	
		int l1= m-l+1;
		int l2= r-m;
		int temp1[] = new int[l1];
		int temp2[] = new int[l2];
		
		for(int i =0;i<l1;i++)
			temp1[i]= arr[l+i];
		
		for (int j=0;j<l2;j++)
			temp2[j]=arr[m+1+j];
		
		int i=0, j=0 , k=l;
		while(i<l1 && j<l2) {
			
			if (temp1[i]<=temp2[j]) {
				
				arr[k]= temp1[i];
				i++;
			}
			else {
				
				arr[k]= temp2[j];
				j++;
				
			}
			k++;
		}
		
		while(i<l1) {
			
			arr[k]=temp1[i];
			i++;
			k++;
			
		}
		while(j<l2) {
			
			arr[k]=temp2[j];
			j++;
			k++;
		}
		return 0;
	}
	
}
