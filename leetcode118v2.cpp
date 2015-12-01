class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        vector<int> row;
        vector<int> pre_row;
        int sum;
        for (int i = 0; i < numRows; ++i)
        {
        	row.clear();
        	row.push_back(1);
        	for(int j = 1; j < i; j++)
        	{
        		sum = pre_row[j] + pre_row[j-1];
        		row.push_back(sum);
        	}
        	if(i > 0)
        		row.push_back(1);
        	pre_row.clear();
        	pre_row = row;
        	res.push_back(row);
        }
        return res;
    }
};