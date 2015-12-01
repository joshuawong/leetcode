class Solution {
public:
	void backtarck(vector<vector<int> >res, vector<bool> flag,vector<int> tmp, vector<int> candidates,int target)
	{
		if(target == 0)
		{
			bool found = false;
			for(vector<vector<int> >::iterator it = res.begin(); it!= res.end();it++)
			{
				if(tmp == *it)
				{
					found = true;
					break;
				}
			}
			if(!found)
				res.push_back(tmp);
			return;
		}
		else if (target < 0)
		{
			return;
		};
		int max = 0;
		for (int i = 0; i < tmp.size(); ++i)
		{
			if(tmp[i] > max)
				max = tmp[i]
		}
		for (int i = 0; i < candidates.size(); ++i)
		{
			if(!flag[i] && candidates[i] >= max)
			{
				flag[i] = true;
                tmp.push_back(candidates[i]);
                combinationSum2Helper(ans, flag, tmp, candidates, target - candidates[i]);
                tmp.pop_back();
                flag[i] = false;
			}
		}
	}

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<int> tmp;
        vector<vector<int> >res;
        vector<bool> flag(candidates.size(),false);
        sort(candidates.begin(),candidates.end());
        backtarck(res,flag,tmp,candidates,target);
        return res;
    }
};