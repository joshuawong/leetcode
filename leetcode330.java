/*
Solution: DP
Reference: https://leetcode.com/discuss/83272/share-my-thinking-process
*/
public class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        long sum = 0;
        int i = 0;
        while(sum < n){
            if(i >= nums.length || nums[i] > sum+1){
                // case: reach the end of nums array || case: exist a gap between sum and the next number
                count++;
                sum = (sum<<1) + 1;
            }
            else{
                sum += nums[i];
                i++;
            }            
        }
        return count;
        
    }
}
