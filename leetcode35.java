class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int size = nums.size();
        vector<int>::iterator res;
        res = find(nums.begin(),nums.end(),target);
        if (res == nums.end()) //not found
        {
         	if (target < nums[0])
         	{
         		return 0;
         	}
         	else
         	{
         		for (int i = 0; i < size; ++i)
         		{
         			if (target < nums[i])
         			{
         				return i;
         			}
         		}
         		return size;
         	}
         	
        } 
        else
        {
        	for (int i = 0; i < size; ++i)
        	{
        		if(nums[i] == target)
        			return i;
        	}
        }
    }
};
