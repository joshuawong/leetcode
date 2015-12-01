class Solution {
public:
    bool isHappy(int n) {
    	vector<int> nums;
    	int result;
    	while(true)
    	{
    		if(n == 1)
    			return true;
    		nums.push_back(n);
    		result = 0;
    		while(n != 0)
    		{
    			result += (n % 10) * (n % 10);
    			n = n / 10;
    		}
	        for (int i = 0; i < nums.size(); ++i)
	        {
        		if(nums[i] == result)
        			return false;
        	}
        	n = result;
    	}
    }
};