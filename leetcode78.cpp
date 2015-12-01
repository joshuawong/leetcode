class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int> > res;
        res.push_back(vector<int>());
        sort(nums.begin(),nums.end());
        for(int num:nums)
        {
        	int n = res.size();
        	for (int i = 0; i < n; ++i)
        	{
        		auto list = res[i];
        		list.push_back(num);
        		res.push_back(list);
        	}
        }
        return res;
    }
};