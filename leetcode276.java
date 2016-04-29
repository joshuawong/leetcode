/*
Solution: DP
DP formula: dp[i] = (k-1)*dp[i-2] + (k-1)*dp[i-1]
*/
public class Solution {
    public int numWays(int n, int k) {
      if(k == 0 || n == 0)
        return 0;
      if(n == 1)
        return k;

      int dp[] = new int[n];
      for(int i = 0; i < n; i++){
        if(i == 0)
          dp[i] = k;
        else if(i == 1)
          dp[i] == k * k;
        else{
          dp[i] = (k-1) * dp[i-2] + (k-1) * dp[i-1];
        }
      }
      return dp[n-1];
    }
}
