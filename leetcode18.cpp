class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        vector<vector<int> > res;
        int len = nums.size();

        for(int i = 0; i < len - 3; i++)
        {
        	for(int j = i+1; j < len - 2; ++j)
        	{
        		int first = j + 1, second = len - 1;
        		while(first < second)
        		{
        			if(nums[i] + nums[j] + nums[first] + nums[second] < target)
        				first++;
        			else if(nums[i] + nums[j] + nums[first] + nums[second] > target)
        				second--;
        			else
        			{
        				vector<int> tmp(4);
        				tmp[0] = nums[i];
        				tmp[1] = nums[j];
        				tmp[2] = nums[first];
        				tmp[3] = nums[second];
        				res.push_back(tmp);

        				first++;
        				while(first < second && nums[first] == nums[first-1])
        					first++;
        				second--;
        				while(second > first && nums[second] == nums[second+1])
        					second--;
        			}
        		}
        		while(j < len - 2 && nums[j] == nums[j+1])
        			j++;
        	}
        	while(i < len - 3 && nums[i] == nums[i+1])
        		i++;
        }
        return res;
    }
};
