public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m < n)
            return 0;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 0; i < m; i++)
            dp[i][0] = 1;
            
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n && j <= i; j++){
                if(i == j){
                // 	System.out.println(s.substring(0,i));
                // 	System.out.println(t.substring(0,j));
                // 	System.out.println(s.substring(0,i).equals(t.substring(0,j)));
                    dp[i][j] = s.substring(0,i).equals(t.substring(0,j)) ? 1 : 0;
                    System.out.println(dp[i][j]);
                }
                else{
                    if(s.charAt(i-1) != t.charAt(j-1)){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
