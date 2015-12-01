//version 3: 投票算法
//时间复杂度 O(n)
//实现方式:
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int major, count = 0; 
        int n = nums.size();
        for (int i = 0; i < n; ++i)
        {
        	if(!count)
        	{
        		major = nums[i];
        		count = 1;
        	}
        	else
        		count += (nums[i] == major) ? 1 : -1;
        }
        return major;
    }
};