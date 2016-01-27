//类似于桶排序，交换数组元素，使得数组中第i位存放数值(i+1);  
//最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。整个过程需要遍历两次数组，复杂度为O(n)。 
class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int n = nums.size();
        for (int i = 0; i < n; ++i)
        {
        	while(nums[i] > 0 && nums[i] < n && nums[nums[i]-1] != nums[i])
        	{
        		swap(nums[nums[i]-1], nums[i]);
        	}
        }

        for (int i = 0; i < n; ++i)
        {
        	if(nums[i] != i+1)
        		return i+1;
        }
        return n+1;
    }
};
