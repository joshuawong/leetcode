class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
    	vector<vector<int> > res(n,vector<int>(n,0));
        int count = 1;
        int size = n - 1;
        int i = 0, j = 0;
        while(size > 0)
        {
        	for(int k = 0; k < size; ++k)
        		res[i][j++] = count++;
        	for(int k = 0; k < size; ++k)
        		res[i++][j] = count++;
        	for(int k = 0; k < size; ++k)
        		res[i][j--] = count++;
        	for(int k = 0; k < size; ++k)
        		res[i--][j] = count++;
        	i++;
        	j++;
        	size = size - 2;
        }
        if(size == 0)
        	res[i][j] = count;
        return res;
    }
};