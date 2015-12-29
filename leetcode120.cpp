class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        for(int i = triangle.size()-2; i >=0; --i)
            for(int j = 0; j < triangle[i].size(); ++j)
                triangle[i][j] += min(triangle[i+1][j],triangle[i+1][j+1]);
        return triangle[0][0];
        
        
        
        /*int h = triangle.size();
        vector<int> dp(h);
        int sum = 0;
        for(int i = 0; i < h; ++i)
            dp[i] = -10000;
        if(h == 1)
            return triangle[0][0];
        dp[0] = triangle[0][0];
        sum = sum + dp[0];
        int tmp = 0;
        for(int i = 1; i < h; i++)
        {
            for(int j = 0; j < triangle[i].size(); ++j)
            {
                tmp = triangle[i][0];
                //dp[i] = triangle[i][0];
                if(triangle[i][j] < tmp)
                    tmp = triangle[i][j];
            }
            dp[i] = tmp;
            sum += dp[i];
        }
        return sum;*/
    }
};
