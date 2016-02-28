public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length-3;i++){
           // List<List<Integer>> tmp = new Array<>();
            res.addAll(threeSum(nums,i+1,target-nums[i]));
            for (int prev = nums[i], next = nums[i+1]; prev == next && i < nums.length-2; prev = next, next = nums[++i + 1]);
        }
        return res;
    }
    
    private List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> sums = new ArrayList<>();
        for (int i = start; i < nums.length-2; i++) {
            int first = nums[i];
            if (first * 3 > target) break;
            for (int l = i+1, r = nums.length-1; l < r; ) {
                if (nums[r] * 3 < target) break;
                int sum = first + nums[l] + nums[r];
                if (sum == target) {
                    sums.add(Arrays.asList(nums[start-1], first, nums[l], nums[r]));
                }
                if (sum > target) {
                    while (l < --r && nums[r] == nums[r+1]);
                } else {
                    while (++l < r && nums[l] == nums[l-1]);
                }
            }
            for (int prev = nums[i], next = nums[i+1]; prev == next && i < nums.length-2; prev = next, next = nums[++i + 1]);
        }
        return sums;
    }
}
