/*
Time: O(n). one-pass
Space: O(1)
*/

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
      List<String> res = new ArrayList<>();
      int next = lower;
      for(int i = 0; i < nums.length; i++){
        if(nums[i] < next)
          continue;
        if(nums[i] == next){
          next++;
          continue;
        }

        res.add(getRange(next, a[i] - 1));

        next = a[i] + 1;
      }

      if(next <= upper)
        res.add(res.add(getRange(next, upper)));

      return res;
    }

    private String getRange(int left, int right){
      return left == right ? String.valueOf(left) : String.format("%d->%d", left, right);
    }
}
