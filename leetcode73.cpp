class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        int row = matrix.size();
        int col = matrix[0].size();
        vector<bool> clearRow(row),clearCol(col);
        for (int i = 0; i < row; ++i)
        {
        	for (int j = 0; j < col; ++j)
        	{
        		if(!matrix[i][j])
        		{
        			clearRow[i] = true;
        			clearCol[j] = true;
        		}
        	}
        }
        for (int i = 0; i < row; ++i)
        {
        	for(int j = 0; j < col; ++j)
        	{
        		if(clearRow[i] || clearCol[j])
        			matrix[i][j] = 0;
        	}
        }
    }
};
