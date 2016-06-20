public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int index = 0; // current zero position
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                index++;
            }
        }
    }
}
