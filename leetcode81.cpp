class Solution {
public:
    bool search(vector<int>& nums, int target) {
        if(nums.size() == 0)
        	return false;
        int left = 0, right = nums.size() - 1;
        int mid = 0;
        while(left <= right)
        {
            while(left < right && nums[left] == nums[left+1])
                left++;
            while(right > left && nums[right] == nums[right-1])
                right--;
        	mid = (left + right) / 2;
        	if(nums[mid] == target)
        		return true;
        	else if (nums[right] < nums[mid])
        	{
        		if(target >= nums[left] && target < nums[mid])
        			right = mid - 1;
        		else
        			left = mid + 1;
        	}
        	else
        	{
        		if(target > nums[mid] && target <= nums[right])
        			left = mid + 1;
        		else
        			right = mid - 1;
        	}
        }
        return false;
    }
};
