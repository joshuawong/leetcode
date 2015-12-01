#include <iostream>
#include <Math.h>
#include <stdlib.h>
using namespace std;
int overarea(int A, int B, int C, int D, int E, int F, int G, int H)
{
        int h1 = abs(max(A,E));
        int h2 = abs(min(C,G));
        int h = h2 - h1;
        cout << h1 << "  " << h2 << endl;
        int v1 = max(B,F);
        int v2 = min(D,H);
        int v = v2 - v1;
        cout << h <<endl;

        if(h <= 0 || v <= 0) return 0;
        else
        return h*v;

}

int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
{
        int area1 = (C-A) * (D-B);
        int area2 = (G-E) * (H-F);
        int overArea = overarea(A,B,C,D,E,F,G,H);
        cout << overArea << endl;
        return area1 + area2 - overArea;
}




int main(int argc, char const *argv[])
{
    int a,b,c,d,e,f,g,h;
    /*a = -1500000001;
    b = 0;
    c = -1500000000;
    cout << c-a<<endl;
    d = 1;
    e = 1500000000;
    f = 0;
    g = 1500000001;
    cout << g-e <<endl;
    h = 1;*/
    cin >> a >> b >> c >> d >> e >> f >> g >> h;
    int area = computeArea(a,b,c,d,e,f,g,h);
    cout << area;

    return 0;
}
