public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 2; i++){
            int l = i + 1, r = nums.length - 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] < target){
                    count += r - l;
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return count;
    }
}
