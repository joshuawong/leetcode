class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        map<int,int> count;
        vector<int> res;
        for (int i = 0; i < nums.size(); ++i)
        {
        	++count[nums[i]];
        }
        for(map<int,int>::const_iterator it = count.begin(); it != count.end(); ++it)
        {
        	if(it->second == 1)
        		res.push_back(it->first);
        }
        return res;
    }
};