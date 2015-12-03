class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int cur = 0;
        int res = nums[0];
        for (num:nums)
        {
        	cur = cur>0? cur+num:num;
        	if(cur > res)
        		res = cur;
        }
        return res;
    }
};
