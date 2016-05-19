class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int start = 0, end = nums.size(), mid,left,right;
        while(start < end)
        {
        	mid = (start + end) / 2;
        	if(nums[mid] >= target)
        	{
        		end = mid;
        	}
        	else
        	{
        		start = mid + 1;
        	}
        }
        left = start;  //find the left bound
        start = 0;
        end = nums.size();
        while(start < end)
        {
        	mid = (start + end) / 2;
        	if(nums[mid] > target)
        	{
        		end = mid;
        	}
        	else
        	{
        		start = mid + 1;
        	}
        }
        right = start;
        vector<int> res;
        if(left == right)
        {
        	res = {-1,-1};
        }
        else
        {
        	res = {left,right-1};
        }
        return res;
    }
};
