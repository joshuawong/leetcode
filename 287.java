public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int l = 1, r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for(int num : nums){
                if(num <= mid)
                    cnt++;
            }
            if(cnt > mid)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
