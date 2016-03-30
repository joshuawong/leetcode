public class Solution {
    public int[] countBits(int num) {
        if(num <= 0){
            return new int[1];
        }
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        int i = 2;
        int powerOfTwo = 2;
        while(i <= num){
            if(i == powerOfTwo){
                dp[i] = 1;
                powerOfTwo *= 2;
            }
            else{
                dp[i] = 1 + dp[i - powerOfTwo/2];
            }
            i++;
        }
        return dp;
    }
}
