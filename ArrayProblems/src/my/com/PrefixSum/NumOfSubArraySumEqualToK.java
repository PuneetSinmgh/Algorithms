class Solution {
    public int subarraySum(int[] nums, int k) {
 
        if(nums.length == 0)
            return 0;
        
/*       int currentsum = 0, count=0, start =0;
        
        for(int j=0; j <nums.length; j++){
                start =j;       
            for(int i=j ; i <nums.length; i++){
            
                currentsum +=nums[i];
            
                if(currentsum==k)
                    count++;
                    
                   
            }
            currentsum=0 ;
        }
        
        return count;
    }*/

        /* approach 2 ( Prefix sum Brute force):
            - maintain an array of sum of all numbers in array consecutively
            - loop over the new array and check how many places the diff of sum is equal to k
         

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int count =0 ;
        for(int i=1; i < nums.length; i++ ){
            sums[i] = nums[i] + sums[i-1];
        }
        
        for(int j = 0; j < nums.length; j++ ){

            if ( sums[j] == k)
                count++;

            for(int i=0; i < j; i++){
                
                if ( sums[j] - sums[i] == k){
                    count++;
                }

            }
        } */

        /* optimized version
        HashMap<Integer, Integer> hs = new HashMap();
        int count =0 ;

        int sum = 0;
        for(int j = 0; j < nums.length; j++ ){
            
            sum+=nums[j];
            if(sum ==k)
                count++;

            if ( hs.containsKey( sum - k ) ){
                count += hs.get(sum - k);
            }

            hs.put(sum,hs.getOrDefault(sum,0)+1);
        }

        return count;*/

        int sum = 0;
        int count =0;
        int i =0 , j=0;

        while ( i<nums.length  ){
            
            if ( j<nums.length ){
            
                sum += nums[j];

                if(sum >= k){
                    count++;
                    sum -= nums[i]; 
                    i++;
                } else {
                    j++;
                }
            
            } else {

                sum -= nums[i];

                if(sum >= k){
                    count++;
                    i++;
                }
            } 
        }

        return count;
    }
}