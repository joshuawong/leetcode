//先交换第0行与n行，第1行与n-1行...
//再沿对角线交换[i][j]<->[j][i]
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int low = 0;
        int high = matrix.size()-1;
        int tmp = 0;
        while(low<high)
        {
        	for (int i = 0; i < matrix.size(); ++i)
        	{
        		tmp = matrix[low][i];
        		matrix[low][i] = matrix[high][i];
        		matrix[high][i] = tmp;
        	}
        	low++;
        	high--;
        }
        for (int i = 0; i < matrix.size(); ++i)
        {
        	for(int j = i;j < matrix.size();++j)
        	{
        		tmp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = tmp;
        	}
        }
    }
};