package my.com.app;

import java.util.*;

// approach :
// 1. calculate the total damage by summing up all the elements in the damage array
// 2. find the maximum damage in the damage array
// 3. calculate the net damage by subtracting the minimum of maximum damage and armor from the total damage
// 4. return the net damage + 1 (to ensure health is at least 1)



public class Solution {
    public long minimumHealth(int[] damage, int armor) {
        
        //int max_damage = Arrays.stream(damage).max().getAsInt();
        

        //long sum = (long)Arrays.stream(damage).sum();
         long totalDamage = 0;
         int maxDamage =0 ;
        for (int d : damage) {
            totalDamage += d;
            maxDamage = Math.max(maxDamage, d);
        }

        long net_damage = Math.min(maxDamage, armor);

        return totalDamage - net_damage + 1 ;
    }

        public static void main(String[] args) {
        Solution sol = new Solution();
        int[] damage = {2, 7, 4, 3};
        int armor = 4;
        System.out.println(sol.minimumHealth(damage, armor)); // Output: 12
    }

}


