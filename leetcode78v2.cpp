class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
    	sort(nums.begin(),nums.end());
        vector<vector<int> > res;
        res.push_back(vector<int>());
        vector<int> tmp;
        int k = 0;
        int size = nums.size();
        for (int i = 0; i < size; ++i)
        {
        	for(int j = 0; j <= i; ++j)
        	{
        		while(k != size)
        		{
        			tmp.push_back(nums[k])
        			k++:
        		}
        		res.push_back(tmp);
        	}	
        }
        return res;
    }
};