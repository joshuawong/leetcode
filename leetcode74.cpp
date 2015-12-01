class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(target < matrix[0][0])
        	return false;
        int i = 0;
        int row = matrix.size();
        int col = matrix[0].size();
        while(i < row)
        {
        	if(target > matrix[i][col - 1])
        		i++;
        	else
        	{
        		for(int j = 0; j < col;++j)
        		{
        			if(target == matrix[i][j])
        				return true;
        		}
        		return false;
        	}
        }
        return false;
    }
};