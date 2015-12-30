class Solution {
public:
    string intToRoman(int num) {
        string ret = "";
        int tmp = num;
        while(tmp >= 1000)
        {
        	ret += "M";
        	tmp -= 1000;
        }
        if(tmp >= 900)
        {
        	ret += "CM";
        	tmp -= 900;
        }
        if(tmp >= 500)
        {
        	ret += "D";
        	tmp -= 500;
        }
        if(tmp >= 400)
        {
        	ret += "CD";
        	tmp -= 400;
        }
        while(tmp >= 100)
        {
        	ret += "C";
        	tmp -= 100;
        }
        if(tmp >= 90)
        {
        	ret += "XC";
        	tmp -= 90;
        }
        if(tmp >= 50)
        {
        	ret += "L";
        	tmp -= 50;
        }
        if(tmp >= 40)
        {
        	ret += "XL";
        	tmp -= 40;
        }
        while(tmp >= 10)
        {
        	ret += "X";
        	tmp -= 10;
        }
        if(tmp >= 9)
        {
        	ret += "IX";
        	tmp -= 9;
        }
        if(tmp >= 5)
        {
        	ret += "V";
        	tmp -= 5;
        }
        if(tmp >= 4)
        {
        	ret += "IV";
        	tmp -= 4;
        }
        while(tmp >= 1)
        {
        	ret += "I";
        	tmp -= 1;
        }
        return ret;
    }
};
