public class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            int tmp = x % 10;
            int tmpres = res * 10 + tmp;
            if((tmpres-tmp)/10 != res)
                return 0;
            res = tmpres;
            x = x/10;
        }
        return res;
    }
}
