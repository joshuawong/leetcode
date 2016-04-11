public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int ele2 = 2, ele3 = 3, ele5 = 5;
        for(int i = 1; i < n; i++){
            int min = Math.min(ele5, Math.min(ele2,ele3));
            ugly[i] = min;
            if(ele2 == min)
                ele2 = 2 * ugly[++idx2];
            if(ele3 == min)
                ele3 = 3 * ugly[++idx3];
            if(ele5 == min)
                ele5 = 5 * ugly[++idx5];
        }
        return ugly[n-1];
    }
}
