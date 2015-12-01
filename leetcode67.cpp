class Solution {
public:
    string addBinary(string a, string b) {
        int c = 0;
        string res = "";
        int len1 = a.size() -1;
        int len2 = b.size() -1;
        while(len1 >=0 || len2 >=0 || c == 1)
        {
        	c +=  len1 >=0 ? a[len1--] - '0': 0;
        	c += len2 >=0 ? b[len2--] - '0': 0;
        	res = char(c % 2 + '0') + res;
        	c /= 2;
        }
        return res;
    }
};