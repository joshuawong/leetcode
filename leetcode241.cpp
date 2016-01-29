class Solution {
public:
    vector<int> diffWaysToCompute(string input) {
        vector<int> res;
        for (int i = 0; i < input.size(); ++i)
        {
        	if(!isdigit(input[i]))
        	{
        		vector<int> left = diffWaysToCompute(input.substr(0,i));
        		vector<int> right = diffWaysToCompute(input.substr(i+1));
        		for(int l = 0; l < left.size(); l++)
        		{
        			for(int r = 0; r < right.size(); r++)
        			{
        				if(input[i] == '+')
        					res.push_back(left[l] + right[r]);
        				else if(input[i] == '-')
        					res.push_back(left[l] - right[r]);
        				else 
        					res.push_back(left[l] * right[r]);
        			}
        		}
        	}
        }
        if(res.empty())
        	res.push_back(atoi(input.c_str()));
        return res;
    }
};
