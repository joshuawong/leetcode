class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> row(rowIndex+1);
        vector<int> pre_row;
        int tmp = 0;
        for (int i = 0; i <= rowIndex; ++i)
        {
            pre_row = row;
        	for(int j = 0; j <= i; ++j)
        	{
        		if(j == 0 || j == i)
                    row.push_back(1);
                else
                {
                    tmp = pre_row[j-1] + pre_row[j];
                    row.push_back(tmp);
                }
        	}
        }
        return row;
    }
};