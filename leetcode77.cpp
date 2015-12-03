class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int> > res;
        vector<int> tmp(k,0);
        int i = 0;
        while(i >= 0)
        {
        	tmp[i]++;
        	if(tmp[i] > n)
        		i--;
        	else if(i == k-1)
        		res.push_back(tmp);
        	else
        	{
        		i++;
        		tmp[i] = tmp[i-1];
        	}
        }
        return res;
    }
};
