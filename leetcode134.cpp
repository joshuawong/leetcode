class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int j;
        for (int i = 0; i < gas.size(); i+=j)
        {
        	int left = 0;
        	for(j = 1; j <= gas.size(); ++j)
        	{
        		int k = (i+j-1) % gas.size();
        		left = left + gas[k] - cost[k];
        		if(left < 0)
        			break;
        	}
        	if(j > gas.size())
        		return i;
        }
        return -1;
    }
};
