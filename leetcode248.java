/*
Solution: based on the solution of 247 Strobogrammatic Number II
*/

public class Solution {
    char[][] dict = new char[][]{{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};

    public int strobogrammaticInRange(String low, String high) {
      List<String> res = new ArrayList<>();
      for(int len = low.length(); len <= high.length(); len++){
        char[] cur = new char[len];
        find(len, len, 0, cur, res);
      }
      int count = 0;
      long lower = Long.valueOf(low);
      long upper = Long.valueOf(high);
      for(int i = 0; i < res.size(); i++){
        if(Long.valueOf(res.get(i)) >= lower && Long.valueOf(res.get(i)) <= upper)
          count++;
        else if(Long.valueOf(res.get(i)) > upper)
          break;
        else
          continue;
      }
      return count;
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
