class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        if(nums.size() == 0)
            return 0;
        int len = -1;
        for (int i = 0; i < nums.size(); ++i)
        {
        	if(nums[i] != val)
        		nums[++len] = nums[i];
        }
        return len+1;
    }
};