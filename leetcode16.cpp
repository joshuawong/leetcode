class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(),nums.end());

        int dis = INT_MAX;
        int sum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.size()-2; ++i)
        {
        	int begin = i + 1;
        	int end = nums.size() - 1;
        	while(begin < end)
        	{
        		if(abs(nums[begin] + nums[end] + nums[i] - target) < dis)
        		{
        			sum = nums[begin] + nums[end] + nums[i];
        			dis = abs(nums[begin] + nums[end] + nums[i] - target);
        		}
        		if(nums[begin] + nums[end] + nums[i] == target)
        			return sum;
        		else if(nums[begin] + nums[end] + nums[i] < target)
        			++begin;
        		else 
        			--end;
        	}
        }
        return sum;
    }
};