public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        while(m != n){
            m >>= 1;
            n >>= 1;
            res++;
        }
        // only the left header all contain 1, here m/n all equal to left head
        return n << res;
    }
}
