class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.empty())
            return 0;
        int n = nums.size();
        int dp[n+1];
        //int res1,res2;
        dp[0] = nums[0];
        for (int i = 1; i < n-1 ; ++i)
        {  
            dp[i] = max(dp[i - 1],  (i==1? 0: dp[i-2])+nums[i] );  
        }  
        int res1 = dp[n-2];
        dp[1] = nums[1];  
        for (int i = 2; i < n ; ++i){  
            dp[i] = max(dp[i - 1], (i == 2 ? 0 : dp[i - 2]) + nums[i]);  
        }  
        int res2 = dp[n-1 ];  
        return max(res1,res2);
    }
};
