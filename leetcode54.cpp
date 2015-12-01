//螺旋输出矩阵的数字
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        if(matrix.empty() || matrix[0].empty())
        	return vector<int>();
        vector<int> path;
        int top = 0;
        int bot = matrix.size() - 1;
        int lef = 0;
        int rgt = matrix[0].size() - 1;
        int i=0,j=0;
        while(top <= bot && lef <=rgt)
        {
        	while(top <= bot && lef <= rgt && j <= rgt)
        		path.push_back(matrix[i][j++]);
        	i = i + 1;
        	j = j - 1;
        	top = top + 1;
        	while(top <= bot && lef <= rgt && i <= bot)
        		path.push_back(matrix[i++][j]);
        	i = i - 1;
        	j = j - 1;
        	rgt = rgt - 1;
        	while(top <= bot && lef <= rgt && j >= lef)
        		path.push_back(matrix[i][j--]);
        	i = i - 1;
        	j = j + 1;
        	bot = bot - 1;
        	while(top <= bot && lef <= rgt && i >= top)
        		path.push_back(matrix[i--][j]);
        	i = i + 1;
        	j = j + 1;
        	lef = lef + 1;
        }
        return path;
    }
};