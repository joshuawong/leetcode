//二分查找法
class Solution {
public:
    int findMin(vector<int>& nums) {
        int begin = 0;
        int end = nums.size() - 1;
        while(begin < end)
        {
        	if(nums[begin] < nums[end])
        		return nums[begin];
        	int mid = (begin + end) / 2;
        	if(nums[mid] >= nums[begin])
        		begin = mid+1;
        	else
        		end = mid;
        }
        return nums[begin];
    }
};
