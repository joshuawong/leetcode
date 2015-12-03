class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n,1);
        for (int i = 0; i < nums.size(); ++i)
        {
            if(i == 0)
                res[i] = 1;
            else
                res[i] = res[i-1] * nums[i-1];
        }
        int r = 1;
        for (int i = nums.size()-1; i >= 0; --i)
        {
            res[i] *= r;
            r *= nums[i];
        }
        return res;
    }
};
