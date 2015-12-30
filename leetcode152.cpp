class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) 
            return nums[0];
        int pmax = 0,nmax = 0, m = 0;
        for(int i = 0; i < n; ++i)
        {
            if(nums[i] < 0)
                swap(pmax,nmax);
            pmax = max(pmax * nums[i], nums[i]);
            nmax = min(nmax * nums[i], nums[i]);
            m = max(m,pmax);
        }
        return m;
        /*vector<int> dp(n);
        for(int i = 0; i < n; ++i)
            dp[i] = 0;
        dp[0] = nums[0];
        for(int i = 1; i < n; i++)
        {
            if((dp[i-1] < 0 && nums[i] < 0) || (dp[i-1] > 0 && nums[i] > 0))
                dp[i] = dp[i-1] * nums[i];
            else if(dp[i-1] <= 0 && nums[i] > 0)
                dp[i] = nums[i];
            else if(dp[i-1] > 0 && nums[i] <= 0)
                dp[i] = dp[i-1];
            else if(dp[i-1] = 0 && nums[i] < 0)
                dp[i] = 0;
            //else if(dp[i-1] < 0 && nums[i] = 0)
             //   dp[i] = nums[i];
            else
                dp[i] = dp[i-1];
        }
        return dp[n-1];*/
    }
};
