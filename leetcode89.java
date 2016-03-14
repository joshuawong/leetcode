/*n=0时，result={0}

n=1时，result={0,1}。1可以看做对0的第1位置1后再次加入。

n=2时，result={00,01,11,10}。11可以看做对01的第2位置1,10可以看做对00的第2位置1后再次加入。

……*/

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i = 0; i < n; i++){
            // int size = res.size();
            for(int j = res.size()-1; j >= 0; j--){
                int num = res.get(j);
                num += 1<<i;
                res.add(num);
            }
        }
        return res;
    }
}
