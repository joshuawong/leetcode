class Solution {
public:
	string digits[20] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    string tens[10] = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    string inttostring(int n)
    {
    	if(n >= 1000000000)
    	{
    		return inttostring(n/1000000000) + " Billion" + inttostring(n%1000000000);
    	}
    	else if(n >= 1000000)
    	{
    		return inttostring(n/1000000) + " Million" + inttostring(n%1000000);
    	}
    	else if(n >= 1000)
    	{
    		return inttostring(n/1000) + " Thousand" + inttostring(n%1000);
    	}
    	else if (n >= 100)
    	{
    		return inttostring(n/100) + " Hundred" + inttostring(n%100);
    	}
    	else if (n >= 20)
    	{
    		return " " + tens[n/10] + inttostring(n%10);
    	}
    	else if (n >= 1)
    	{
    		return " " + digits[n];
    	}
    	else
    	{
    		return "";
    	}
    }

    string numberToWords(int num) {
        string res;
        if(num == 0)
        	return "Zero";
        else
        {
        	res = inttostring(num);
        	return res.substr(1,res.length() -1);
        }
    }
};
