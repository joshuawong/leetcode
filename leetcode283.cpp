class Solution {
public:
    void moveZeroes(vector<int>& nums) 
    {
            for (int i = 0; i < nums.size(); i++) 
            {
                if (nums[i] != 0 && i != 0) 
                {
                    for (int j = i; j > 0 && nums[j - 1] == 0; j--) 
                    {
                        int temp = nums[j - 1];
                        nums[j - 1] = nums[j];
                        nums[j] = temp;
                    }
                }
            }   
    }
};