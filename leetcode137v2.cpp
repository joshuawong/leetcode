class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int tmp = 0;
        for (int i = 1; i < nums.size(); ++i)
        {
        	tmp = nums[0] & (tmp ^ nums[i]);
        	nums[0] = tmp | (nums[0] ^ nums[i]);
        }
        return nums[0];
    }
};