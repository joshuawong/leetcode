import static java.lang.Math.toIntExact;

public class Solution {
    public int mySqrt(int x) {
        if(x == 0)
        	return 0;
        if(x == 1)
        	return 1;
        long left = 1;
        long right = x;
        long mid = 0;
        while(left <= right)
        {
        	mid = left + (right - left) / 2;
        	if(mid * mid > x)
        		right = mid - 1;
        	else if(mid * mid < x)
        		left = mid + 1;
        	else
        	{
        		int res = toIntExact(mid);
        		return res;
        	}
        }
        int res = toIntExact((left + right) / 2);
        return res;
    }
}
