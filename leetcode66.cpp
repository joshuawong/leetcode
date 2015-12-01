class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int flag = 1;
        for (int i = digits.size() - 1; i >= 0; --i)
        {
        	digits[i] = digits[i] + flag;
        	if(digits[i] == 10)
        	{
        		flag = 1;
        		digits[i] = 0;
        	}
        	else
        		flag = 0;
        }
        if(flag == 1)
        {
        	digits.insert(digits.begin(),1);
        }
        return digits;
    }
};