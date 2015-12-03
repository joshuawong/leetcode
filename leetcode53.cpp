class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.size(); ++i)
        {
        	sum = sum + nums[i];
        	res = max(res,sum);
        	sum = max(sum,0);
        }
        return res;
    }
};
