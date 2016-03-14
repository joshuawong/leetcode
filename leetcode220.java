public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0 || nums.length < 2){
            return false;
        }
        SortedSet<Long> set = new TreeSet<Long>();
        for(int i = 0; i < nums.length; i++){
            SortedSet subSet = set.subSet((long)nums[i]-t,(long)nums[i]+t+1); // search nums[j] which different from nums[i] at most t
            if(!subSet.isEmpty()){
                return true; // exist such nums[j] satisify requirement
            }
            if(i >= k){
                set.remove((long)nums[i-k]); // the difference between i and j larger than k, remove previous value.
            }
            set.add((long)nums[i]);
        }
        return false;
    }
}
