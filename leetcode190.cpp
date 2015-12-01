class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t res = 0;
        uint32_t tmp[32];
        for (int i = 31; i >= 0; --i)
        {
        	tmp[31-i] = pow(2,i);
        }
        for(int j = 0; j < 32; ++j)
        {
        	if(n&1)
        		res += tmp[j];
        	n = n >> 1;
        }
        return res;
    }
};