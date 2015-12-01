class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    vector<int> result;
    for(int i = 0; i < nums.length; ++i)
        for(int j = 0; j < nums.length; ++j)
            if(nums[i] + nums[j] == target)
            {
                result[0] = i + 1;
                result[1] = j + 1；
                return result
            }
    }
};