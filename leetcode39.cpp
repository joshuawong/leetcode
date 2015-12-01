//backtracking DFS+剪枝法
class Solution {
private:
	void backtrack(int sum, int start, vector<int>tmp,vector<int>candidates, vector<vector<int>>&result,int target)
	{
		if(target == sum)
		{
			result.push_back(tmp);
			return;
		}
		if(sum > target)
			return;
		for (int i = start; i < candidates.size(); ++i)
		{
			tmp.push_back(candidates[i]);
			backtrack(sum+candidates[i],i,tmp,candidates,result,target);
			tmp.pop_back();//backtrack
		}
	}
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(),candidates.end());
        candidates.erase(unique(candidates.begin(), candidates.end()),candidates.end());  
        vector<vector<int> > result;
        vector<int> tmp;
        int start = 0;
        backtrack(0,start,tmp,candidates,result,target);
        return result;
    }
};