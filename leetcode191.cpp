// 时间复杂度 O(M) M为1的个数
//实现方法 n & (n-1)
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int count = 0;
        while(n)
        {
        	n &= (n-1);
        	++count;
        }
        return count;
    }
};