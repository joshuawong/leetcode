//只有2*5 会产生0， 因此只需要计算有多少个5就可以了
class Solution {
public:
    int trailingZeroes(int n) {
        int res = 0;
        if(n < 5)
        	return 0;
        while(n / 5 != 0)
        {
        	n /= 5;
        	res += n;
        	
        }
        return res;
    }
};