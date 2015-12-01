class Solution {
public:
    int addDigits(int num) {
        if(num >= 10)
        {
            while(num >= 10)
            {
                num = num / 10 + num % 10;
            }
        }
        return num;
    }
};