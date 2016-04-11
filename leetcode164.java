public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int maxDis = 0;
        for(int i = 1; i < nums.length; i++){
            if(Math.abs(nums[i] - nums[i-1]) > maxDis){
                maxDis = Math.abs(nums[i] - nums[i-1]);
            }
        }
        return maxDis;
    }
}
