class Solution {
public:
    string convertToTitle(int n) {
        string s;
        int i = 0;
        while(n >= 1)
        {
        	n--;
        	s.insert(0,1,n%26+'A');
        	n = n / 26;
        }	
        return s;
    }
};