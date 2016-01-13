class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        int n = nums.size();
        int sum = 0, begin = 0, min = INT_MAX;
        for (int i = 0; i < n; ++i)
        {
        	sum += nums[i];
        	while(sum >=s)
        	{
        		min = min(min,i - begin + 1);
        		sum -= nums[begin++];
        	}
        }
        return min == INT_MAX?0:min;
    }
};
