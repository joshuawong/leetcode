class Solution {
public:
    int countPrimes(int n) {
        if(n<=2) return 0;
        vector<bool> pass(n,false);
        int count = 1;
        int upper = sqrt(n);
        for(int i = 3; i < n; i+=2)
        {
        	if(!pass[i])
        	{
        		count++;
        		if(i > upper)
        			continue;
        		for (int j = i*i; j < n; j+=i)
        		{
        			pass[j] = true;
        		}
        	}
        } 
        return count;
    }
};