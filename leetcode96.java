/*
suppose f(i) denotes number of Unique Binary Tree [1,i] can produce.
f(i) = f(0)*f(i-1) + ... + f(k-1)*f(i-k) + f(i-1)*f(0)
*/

public class Solution {
    public int numTrees(int n) {
        if(n < 2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i =2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = dp[i] + dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    } 
}
