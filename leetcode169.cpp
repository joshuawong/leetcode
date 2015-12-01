// Divide and Conquer
//时间复杂度 O(nlgn)
class Solution {
private:
	int majority(vector<int>& nums, int left, int right)
	{
		if(left == right) return nums[left];
		int mid = left + ((right - left)>>1);
		int lm = majority(nums,left,mid);
		int rm = majority(nums,mid+1,right);
		if(lm == rm) return lm;
		return return count(nums.begin() + left, nums.begin() + right + 1, lm) > count(nums.begin() + left, nums.begin() + right + 1, rm) ? lm : rm;
	}
public:
    int majorityElement(vector<int>& nums) {
        return majority(nums, 0, nums.size()-1);
    }
};