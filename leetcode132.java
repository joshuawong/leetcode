public class Solution {
    public int minCut(String s) {
        int n = s.length();
        if(n < 2 || isPalindrome(s, 0, n-1))
        	return 0;
        int[] dp = new int[n+1];
        
        for(int i = 0; i <= n;i++){
            dp[i] = i - 1;
        }
        
        boolean[][] palindrome = new boolean[n+1][n+1];
        
        for(int i = 2; i <= n ; i++){
            for(int j = i-1; j >=0; j--){
                if(s.charAt(i - 1) == s.charAt(j) && (i - 1 - j < 2 || palindrome[j + 1][i - 1])){
                    palindrome[j][i] = true;
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[n];
    }
    
    private boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
