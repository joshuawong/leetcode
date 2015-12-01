class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        vector<int> res = {0,0};
        int tmp = 0;
        for (int i = 0; i < nums.size(); ++i)
        {
        	tmp = tmp ^ nums[i];
        }
        int n;
        n = tmp & (-tmp);
        for (int i = 0; i < nums.size(); ++i)
        {
        	if((n & nums[i]) != 0)
        		res[0] = res[0] ^ nums[i];
        	else
        		res[1] = res[1] ^ nums[i];
        }
        return res;
    }
};