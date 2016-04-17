public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(len <= 1)
            return len;
        
        int[] num = new int[len+1];
        for(int i = 0; i < num.length; i++){
            num[i] = 1;
        }
        
        // first scan: from left to right
        for(int i = 1; i < len; i++){
            if(ratings[i] > ratings[i-1]){
                num[i] = num[i-1] + 1;
            }
        }
        
        // second scan: from right to left
        for(int i = len-1; i> 0; i--){
            if(ratings[i-1] > ratings[i]){
                num[i-1] = Math.max(num[i]+1, num[i-1]);
            }
        }
        
        int res = 0;
        for(int i = 0; i< len; i++){
            res += num[i];
        }
        return res;
    }
}
