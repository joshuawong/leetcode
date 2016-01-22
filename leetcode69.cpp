class Solution {
public:
    int mySqrt(int x) {
    	if(x == 0)
    		return 0;
    	if(x == 1)
    		return 1;
        long long left = 1, right = x;
        long long mid = 0;
        while(left <= right)
        {
        	mid = (left + right)/2;
        	if(mid * mid > x)
        		right = mid - 1;
        	else if(mid*mid < x)
        		left = mid + 1;
        	else
        		return mid;
        }
        return (left + right) / 2;
    }
};
