public class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int last_reach = 0;
        int current_reach = 0;
        for(int i = 0; i < nums.length-1; i++){
            current_reach = Math.max(current_reach, i+nums[i]);
            if(i == last_reach){
                count++;
                last_reach = current_reach;
            }
        }
        return count;
    }
}
