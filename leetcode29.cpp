class Solution {
public:
    int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1)
        {
            //change these two number to positive will overflow
        	return 2147483647;
        }
        static long long int array[40];
        // change number to positive
        long long a = llabs((long long)dividend);
        long long b = llabs((long long)divisor);
        int ret = 0;
        long long sum = 0;
        int i = -1;

        //equal to b*2^i
        while(b <= a)
        {
            array[++i] = b;
            b <<= 1;
        }

        for(int j = i; j >= 0; j--)
        {
            if(sum+array[j] > a)
            {
                continue;
            }
            else
            {
                sum += array[j];
                ret += pow(2, j);
            }
        }
        
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
        {
            return -ret;
        }
        else
        {
            return ret;
        }
    }
};
