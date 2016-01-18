class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int count = 1;
        int max = 1;
        sort(nums.begin(), nums.end());
        for (int i = 1; i < nums.size(); ++i)
        {
            if(nums[i] - nums[i-1] == 1)
            {
                count++;
            }
            else if(nums[i] == nums[i-1])
            {
                continue;
            }
            else
            {
                if(count >= max)
                    max = count;
                count = 1;
            }
        }
        if(count >= max)
            max = count;
        return max;
    }
};
