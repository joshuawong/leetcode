class Solution {
public:
    int numDecodings(string s) {
        int n = s.size();
        if(n == 0)
            return 0;
        int n0 = 1;
        int n1 = (s[0] == '0')?0:1;
        for(int i = 1; i < n; ++i)
        {
            int tmp = n1;
            if(s[i] == '0')
                n1 = 0;
            if((s[i-1] == '2' && s[i] <= '6') || s[i-1] == '1')
                n1+=n0;
            if(n1 == 0)
                return 0;
            n0 = tmp;
        }
        return n1;
    }
};
