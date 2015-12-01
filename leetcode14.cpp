class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.size() == 0)
        	return "";

        int min_len = strs[0].size();
        for (int i = 0; i < strs.size(); ++i)
        {
        	if(strs[i].size() < min_len)
        		min_len = strs[i].size();
        }
        string res("");
        for (int i = 0; i < min_len; ++i)
        {
        	for(int j = 0; j < strs.size() - 1; ++j)
        	{
        		if(strs[j][i] != strs[j+1][i])
        			return res;
        	}
        	res += strs[0][i];
        }
        return res;
    }
};