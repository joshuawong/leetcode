public class Solution {
    public boolean isPowerOfFour(int num) {
            int cnt = 0;
            while (num > 0) 
            {
                cnt += (num & 3);
                num >>= 2;
            }
        return cnt == 1;
    }
}
