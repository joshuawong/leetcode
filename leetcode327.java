public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
      int n = nums.length;
      long[] sum = new long[n+1];
      for(int i = 0; i < n; i++){
        sum[i+1] = sum[i] + nums[i];
      }
      return mergeCount(sum,0,n+1,lower,upper);
    }

    private int mergeCount(long[] sum, int left, int right, int lower, int upper){
      if(right - left <= 1)
        return 0;
      int mid = (left + right) / 2;
      int count = mergeCount(sum,left, mid,lower,upper) + mergeCount(sum, mid, right, lower, upper);
      int j = mid, k = mid, t = mid;
      long[] cache = new long[right - left];
      for(int i = left, r = 0; i < mid; i++, r++){
        while(k < right && sum[k] - sum[i] < lower)
          k++;
        while(j < right && sum[j] - sum[i] <= upper)
          j++;
        while(t < right && sum[t] < sum[i])
          cache[r++] = sum[t++];
        cache[r] = sum[i];
        count += j - k;
      }

      System.arraycopy(cache, 0, sum, left, t - left);
      return count;
    }
}
