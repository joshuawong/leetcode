class Solution {
public:
	void subset(vector<vector<int> > &res, vector<int> &nums, vector<int> &tmp, int begin)
	{
		res.push_back(tmp);
		for (int i = begin; i != nums.size(); ++i)
		{
			if(i == begin || nums[i] != nums[i-1])
			{
				tmp.push_back(nums[i]);
				subset(res,nums,tmp,i+1);
				tmp.pop_back();}
		}
	}

    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int> > res;
        vector<int> tmp;
        subset(res,nums,tmp,0);
        return res;
    }
};
