#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
	int n;
	cin >> n;
	int cnt;
	while(n > 0)
	{
		cnt += (n & 1);
		n >>= 1;
	}
	if (cnt == 1) cout<<'1';
	else cout << '0';
}
