class Solution {
public:
    int minDistance(string word1, string word2) {
        int len1 = word1.size();
        int len2 = word2.size();
        int dp[len1+1][len2+1];
        for (int i = 0; i < len1+1; ++i)
        {
        	dp[i][0] = i;
        }
        for (int i = 0; i < len2+1; ++i)
        {
        	dp[0][i] = i;
        }
        for (int i = 0; i < len1; ++i)
        {
        	for(int j = 0; j < len2; ++j)
        	{
        		if(word1[i] == word2[j])
        			dp[i+1][j+1] = dp[i][j];
        		else
        		{
        			int tmp = min(dp[i][j+1],dp[i+1][j]);
        			dp[i+1][j+1] = min(tmp,dp[i][j]) + 1;
        		}
        	}
        }
        return dp[len1][len2];
    }
};
