/*
Reference: https://www.hrwhisper.me/leetcode-burst-balloons/
DP method: 2 demension dp[][], suppose x between i and j
So, the equation is: dp[i][j] = max(dp[i][j], dp[i][x-1] + nums[x-1]*nums[x]*nums[x+1]+dp[x+1][j])
*/
public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n+2];
        for(int i = 0; i < n; i++){
            balloons[i+1] = nums[i];
        }
        balloons[0] = 1;
        balloons[n+1] = 1;
        int dp[][] = new int[n+2][n+2];
        for(int k = 1;k < n+1; k++){
            for(int left = 1; left <= n-k+1;left++){
                int right = left + k - 1;
                for(int x = left; x <= right;x++){
                    dp[left][right] = Math.max(dp[left][right], dp[left][x-1] + balloons[left-1] * balloons[x] * balloons[right+1] + dp[x+1][right]);//cannot understand this equation
                }
            }
        }
        return dp[1][n];
    }
}
