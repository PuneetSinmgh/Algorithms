package src.my.com.binarysearch;

import java.util.*;

// Approach:
// 1. Sort the array of positions.
// 2. Use binary search to find the maximum distance (gap) between the balls.
// 3. For each mid value in the binary search, check if it's possible to place all balls with that gap.
//    - Start placing the first ball at the first position.
//    - For each subsequent ball, place it at the next position that is at least `mid` distance away from the last placed ball.
// 4. If all balls can be placed with the current gap, update the answer and search for a larger gap.
// 4. If it is possible, update the answer and search for a larger gap.
// 5. If it is not possible, search for a smaller gap.

// time complexity: O(n log(max_distance)), where n is the number of positions
// space complexity: O(1)


class Solution {
    // find maximum gap between the balls with which we can place all balls 
    // if the gap is x and all the ball can be adjusted then , 
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int s = 1; // min gap to star
        int e = (int)Math.ceil(position[n-1]/ (m - 1.0)); // max gap between balls
        int answer = 0;
        while ( s <= e) {
            int mid = s + ( e-s)/2;

            if ( canfitAll( mid , position, m) ){
                answer = mid;
                s = mid+1; // keep looking for max gap between the balls
            } else {
                e = mid-1; // 
            }
        }
        return answer;
        
    }

    public boolean canfitAll(int gap, int[] pos, int m){
        
        int lastPos = pos[0]; 
        int ballCount =1 ; 
        for ( int i=1 ;i < pos.length && ballCount < m; i++ ){
            
            if ( pos[i] - lastPos >= gap){
                ballCount++;
                lastPos = pos[i];
            }
        }

        return ballCount == m;
    }
}