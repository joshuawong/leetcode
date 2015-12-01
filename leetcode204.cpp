class Solution {
public:
	vector<int> v;
	bool isprime(int n)
	{
		if(n < 2) 
			return false;
		if(n == 2)
			return true;
		if(n % 2 == 0)
		    return false;
		int tmp = sqrt(n);
		int len = v.size();
		for (int i = 0; i < len; ++i)
		{
			int temp = v[i];
			if(temp > tmp)
				break;
			if(n % temp == 0)
				return false;
		}
		return true;
	}


    int countPrimes(int n) {
    	int count = 0;
        for (int i = 0; i < n; ++i)
        {
        	if(isprime(i))
        	{
        		count++;
        		v.push_back(i);
        	}		
        }
      	return count;
    }
};