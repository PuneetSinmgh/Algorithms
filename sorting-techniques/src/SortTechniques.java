
public class SortTechniques {

	
	public void bubbleSort(int[] nums) {
		//sorting- Bubble sort
		int len = nums.length;
        int temp;
        for(int i=0; i<len; i++){
            for(int j=0 ; j<len-i-1;j++){
                
                if(nums[j]>nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1]=temp;
                }
                    
            }
        }
	}
	
	public void selectionSort(int[] nums) {
		
		// selection sort
        int len = nums.length;
        int temp, min;
        for(int i=0; i<len; i++){
            min =i ; // assign i as minvalue index

            for(int j=i+1; j<len;j++){
                if(nums[j]< nums[min]){
                    min = j;
                }
            }
            if(min!=i){          // swap if min is not the original value
                temp = nums[min];
                nums[min] = nums[i];
                nums[i]=temp;
            }
        }
	}
	
	public void insertionSort(int[] nums) {
		 // insertion sort
        int len = nums.length;
        int temp;
        for(int i=0; i<len; i++){
            // assign i as minvalue index
            for(int j=i; j>0;j--){
                
                if(nums[j-1]>nums[j]){
                    temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1]=temp;
                }
            }    
        }
	}
	
	public void quickSort(int[] nums, int start , int end) {
		
		int i = start-1;
		int j=start;
		int pivot = nums[end];
		int temp;
		while(j<=end) {
			
			if(nums[j]<=pivot) {
				i++;
				temp = nums[j];
				nums[j]=nums[i];
				nums[i]=temp;
			}else {
				j++;
			}
		}
		
		quickSort(nums,start,i-1);
		quickSort(nums,i+1,end);
		
	}
	
}
