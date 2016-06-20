public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(sum - target) < min){
                    min = Math.abs(sum - target);
                    res = sum;
                }
                if(sum < target)
                    l++;
                else if(sum > target)
                    r--;
                else
                    return sum;
            }
        }
        return res;
    }
}
