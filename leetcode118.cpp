class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res(numRows);
        int i = 0, j = 0;
      //  cout << '[' << endl;
        for (i = 0; i < numRows; ++i)
        {
        	res[i].resize(i+1);
        //	cout << '[';
        		for(j = 0; j <= i;j++)
        		{
        			if(j == 0 || j == i)
        				res[i][j] = 1;
        			else
        				res[i][j] = res[i-1][j-1] + res[i-1][j];
        		}
        }
        return res;
    }
};