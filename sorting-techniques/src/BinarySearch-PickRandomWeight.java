class Solution {

    double[] prob;
    int sum = 0;
    Random rand = new Random();
    public Solution(int[] w) {
        prob = new double[w.length];
        
        // calculate prefix sum to find a random sum in prefix array
        for(int i =0 ;i < w.length; i++){
            sum += w[i];
            prob[i] = sum ;
        }

    }
    
    public int pickIndex() {
        // total sum represent total chances , out of which , random sum can be considered 
        double target = this.sum * rand.nextDouble();

        int low = 0, high = prob.length;
        
        // closed prefix sum index to the random sum.
        while(low < high) {

            int mid = low + (high - low)/2;

            if(target > prob[mid] ){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */