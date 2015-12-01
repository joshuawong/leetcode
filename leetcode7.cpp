#include <iostream>
#include <cmath>
using namespace std;

int reverse(int x) {
    int size = 0;
    int result = 0;
    int flag = 0;
    int num = x;
    // calculate the size
    if(x < 0)
    {
        x = -x;
        flag = 1;
    }
    if(x < 10)
    {
        if(flag == 1)
            return -x;
        else
            return x;
    }
    while(num != 0)
    {
        num = num / 10;
        size++;
    }
    //calculate reserve
    int len = size;
    while(size > 0)
    {
        int tmp = pow(10,size-1)+0.5;
        result = result + tmp * (x % 10);
        x = x / 10;
        size--;
    }

    if(flag == 1)
        return -result;
    else
        return result;
}

int main(int argc, char const *argv[])
{
    int num;
    cin >> num;
    num = reverse(num);
    cout << num << endl;
    return 0;
}
