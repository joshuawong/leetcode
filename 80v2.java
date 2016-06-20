public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        if(n <= 1)
            return n;

        int i = 1;
        int j = 0;
        boolean dup = false;

        while(i < n){
            if(nums[i] == nums[j] && dup == true){
                while(i < n && nums[i] == nums[j])
                    i++;
                dup = false;
            }
            else{
                dup = (nums[i] == nums[j]) ? true : false;
                swap(nums, i, j+1);
                i++;
                j++;
            }
        }
        return j+1;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
