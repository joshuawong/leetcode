public class Solution {
    public boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        
        boolean dp[][] = new boolean[lens+1][lenp+1];
        dp[0][0] = true;  // s == null && p == null
        for(int i = 1;i <= lens;++i)
        {
            dp[i][0] = false;  // p == null && s != null
        }
        
        for(int j = 1; j <= lenp;j++)
        {
            if(j == 1)
                dp[0][j] = false;  // s == null && p has only 1 char, must be false
            else
                dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2];  // s == null && p[j-1] == '*' && p[j-2] is not null, is true
        }

        for(int i = 1; i <= lens; ++i)
        {
        	for(int j = 1; j <=lenp; ++j)
        	{
        		if(p.charAt(j-1) != '*')
        		{
        		    // regular case: '.' equals to any char, or p[j-1] == s[i-1]
        			dp[i][j] = dp[i-1][j-1] && (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1));
        		}
        		else
        		{
        		    // if p[j] == '*':
        		    // case 1: p roll back 2 char, if s match p, return true; else false
        		    // case 2: p roll back 2 char, if p == '.'(can match any char) return true; else false
        		    // case 3: idk
        			dp[i][j] = dp[i][j-2] || (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)) && dp[i-1][j];
        		}
        	}
        }
        return dp[lens][lenp];
    }
}
