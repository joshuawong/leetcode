/*假设最终的结果是ABCD

首先确定A。因为k=10 > 3!=6，所以可以算出A应该是1~n里面的第 ceiling{k / 3!}=2个（ceiling表示取上整），即A=2。最后把2从1~n中删除，更新k，令k=k%3!=4

然后确定B。因为k=4 > 2!=2，所以可以算出B应该是1~n里面的第ceiling{k/2!}=2个，因为2之前被删掉了，所以现在第2个数字是3，即B=3。最后把3从1~n中删除，更新k=k%2!=2

接着看C。因为k=0，说明我们要求的序列肯定是某个序列的结尾处，所以之后的数字依次按照从大到小的方式输出即可，即C=4。把4从1~n中删除，继续。

最后看D。因为k=0，同上，可得D=1。*/
class Solution {
public:
    string getPermutation(int n, int k) {
        string res(n,0);
        vector<char> a(n,0);
        int p = 1;
        for(int i = 1; i <= n; i++){
            p *= i;
            a[i-1] = i + '0';
        }
        
        for(int i = 0; i < n; i++){
            if(k > 0){
                int nextp = p / (n - i); // get A
                int order = (k-1)/nextp;
                res[i] = a[order];
                a.erase(a.begin()+order);
                k %= nextp;
                p = nextp;
            }
            else{
                res[i] = a.back();
                a.pop_back();
            }
        }
        return res;
    }
};
