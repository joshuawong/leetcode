public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0)
            return null;
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int tmp = a * num * num + b * num + c;
            res[i] = tmp;
        }
        Arrays.sort(res);
        return res;
    }
}
