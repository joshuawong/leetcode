public class Solution {
    public boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        
        boolean dp[][] = new boolean[lens+1][lenp+1];
        dp[0][0] = true;
        for(int i = 1;i <= lens;++i)
        {
            dp[i][0] = false;
        }
        
        for(int j = 1; j <= lenp;j++)
        {
            if(j == 1)
                dp[0][j] = false;
            else
                dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2];
        }

        for(int i = 1; i <= lens; ++i)
        {
        	for(int j = 1; j <=lenp; ++j)
        	{
        		if(p.charAt(j-1) != '*')
        		{
        			dp[i][j] = dp[i-1][j-1] && (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1));
        		}
        		else
        		{
        			dp[i][j] = dp[i][j-2] || (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)) && dp[i-1][j];
        		}
        	}
        }
        return dp[lens][lenp];
    }
}
