class Solution {
public:
	string dic[10] = {{""},{""},{"abc"},{"def"},{"ghi"},{"jkl"},{"mno"},{"pqrs"},{"tuv"},{"wxyz"}};
    vector<string> letterCombinations(string digits) {
        vector<string> res;
        if(digits.size() == 0)
        	return res;
        int n = digits.size();
        string tmp(n, 0);
        dfs(tmp,0,n,res,digits);
        return res;
    }

    void dfs(string &tmp, int cur, int depth, vector<string> &res, string &digits)
    {
    	if(cur >= depth)
    	{
    		res.push_back(tmp);
    		return;
    	}
    	for (int i = 0; i < dic[digits[cur]-'0'].size(); ++i)
    	{
    		tmp[cur] = dic[digits[cur] - '0'][i];
    		dfs(tmp,cur+1,depth,res,digits);
    	}
    	return;
    }
};
