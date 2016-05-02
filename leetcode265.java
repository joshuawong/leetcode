public class Solution {
    public int minCostII(int[][] costs) {
      if(costs == null || costs.length == 0)
        return 0;

      int m = costs.length;
      int n = costs[0].length;

      int[][] dp = new int[m][n];
      for(int i = 0; i < n; i++){
        dp[0][i] = costs[0][i];
      }

      for(int i = 1; i < m; i++){
        for(int j = 0; j < n; j++){
          dp[i][j] = findLast(i-1, j, dp) + costs[i][j];
        }
      }
      return findLast(m-1, -1, dp);
    }

    private int findLast(int i, int color, int[][] dp){
      int min = Integer.MAX_VALUE;
      for(int i = 0; i < dp[0].length; i++){
        if(i == color)
          continue;

        min = Math.min(min, dp[i][j]);
      }
      return min;
    }
}
