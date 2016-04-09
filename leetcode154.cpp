class Solution {
public:
    int findMin(vector<int>& nums) {
        int begin = 0;
        int end = nums.size() - 1;
        while(begin < end)
        {
        	int mid = begin + (end - begin) / 2;
        	if(nums[mid] > nums[end])
        		begin = mid+1;
        	else if(nums[mid] < nums[end])
        		end = mid;
        	else
        	    end--;
        }
        return nums[begin];
    }
};
