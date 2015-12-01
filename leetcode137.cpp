class Solution {
public:
    int singleNumber(vector<int>& nums) {
        map<int,int> count;
        for (int i = 0; i < nums.size(); ++i)
        {
            ++count[nums[i]];
        }
        for(map<int,int>::const_iterator it = count.begin(); it != count.end(); ++it)
        {
            if(it->second == 1)
                return it->first;
        }
    }
};