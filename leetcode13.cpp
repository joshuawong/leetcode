class Solution {
public:
	int getVal(char a)
	{
		switch(a)
		{
			case 'I':return 1;
			case 'V':return 5;
    		case 'X':return 10;
    		case 'L':return 50;
    		case 'C':return 100;
    		case 'D':return 500;
    		case 'M':return 1000;
		}
		return 0;
	}
    int romanToInt(string s) {
    	int res = 0;
    	char max = 'I';
    	for (int i = s.size()-1; i >= 0; --i)
    	{
    		if(getVal(s[i]) >= getVal(max))
    		{
    			max = s[i];
    			res = res + getVal(s[i]);
    		}
    		else
    			res = res - getVal(s[i]);
    	}
    	return res;
    }
};