#include <iostream>
using namespace std;

bool isPalindrome(int x) 
{
    int low = 0, high = 0;
    int size = 1;
    if(x < 0)
    	return false;
    while(x / size >= 10)
    	size *= 10;
    //reverse
    while(x > 0)
    {
    	high = x / size;
    	low = x % 10;
    	if(high != low)
    		return false;
    	else
    	{
    		x = (x % size) / 10;
    		size /= 100;
    	}
    }
    return true;
}

int main(int argc, char const *argv[])
{
	int num;
	cin >> num;
	bool result = isPalindrome(num);
	cout << result << endl;
	return 0;
}