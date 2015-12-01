class Solution {
    vector<vector<int> > res;
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        if(nums.size()<3)
        	return res;
        sort(nums.begin(),nums.end());

        for (int i = 0; i < nums.size()-2; ++i)
        {
        	if(i>0 && nums[i] == nums[i-1])
        		continue;
        	twoSum(nums,i+1,nums.size()-1,nums[i]);
        }
        return res;
    }

    void twoSum(vector<int>& nums, int begin, int end, int target)
    {
    	int i = begin;
    	int j = end;
    	while(i<j)
    	{
    		if(nums[i]+nums[j]+target == 0)
    		{
    			vector<int> v;
    			v.push_back(target);
    			v.push_back(nums[i]);
    			v.push_back(nums[j]);
    			res.push_back(v);
    			while(i<j && nums[i]==nums[i+1]) 
                    ++i;  // 相等的跳过
                while(i<j && nums[j]==nums[j-1]) 
                    --j;  // 相等的跳过
                ++i;
                --j;
    		}
    		else if(nums[i]+nums[j]+target < 0)
    			++i;
    		else
    			--j;
    	}
    }
};