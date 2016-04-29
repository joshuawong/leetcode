/*
Solution: short Recurion
*/
public class Solution {
    char[][] dict = new char[][]{{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};

    public List<String> findStrobogrammatic(int n) {
      List<String> res = new ArrayList<>();
      char[] cur = new char[n];
      find(n, n, 0, cur, res);
      return res;
    }

    private void find(int n, int m, int j, char[] cur, List<String> res){
      if(m <= 0){
        res.add(new String(cur));
        return;
      }
      for(int i = 0; i < dict.length; i++){
        if(m == 1 && (dict[i][0] == '6' || dict[i][0] == '9')){
          continue;
        }
        if(m > 1 && j == 0 && dict[i][0] == '0'){
          continue;
        }
        cur[j] = dict[i][0];
        cur[n-j-1] = dict[i][1];
        find(n, m-2, j+1, cur, res);
      }
    }
}
