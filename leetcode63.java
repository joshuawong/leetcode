/*
Solution: DP
Time: O(mn)
Sapce: O(mn)
*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0: 1;
        
        if(dp[0][0] == 0){
            return 0;
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else if(i == 0){
                    if(j > 0)
                        dp[i][j] = dp[i][j-1];
                }
                else if(j == 0){
                    if(i > 0)
                        dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
