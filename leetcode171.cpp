#include <iostream>
#include <string>
using namespace std;

int titleToNumber(string s)
{
    int sum = 0;
    int tmp = 0;
    for (int i = 0; i < s.size(); ++i)
    {
    	tmp = s[i] - 'A' + 1;
    	sum = sum * 26 + tmp;
    }
    return sum;
}

int main(int argc, char const *argv[])
{
	string a;
	cin >> a;
	int res = titleToNumber(a);
	cout << res << endl;
	return 0;
}
