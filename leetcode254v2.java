// use sqrt(n) as upper instead of n
// Runtime: 2ms

public class Solution {
    public List<List<Integer>> getFactors(int n) {
      List<List<Integer>> res = new ArrayList<>();
      if(n <= 3)
        return res;
      dfs(n, -1, res, new ArrayList<Integer>());
      return res;
    }

    private void dfs(int n, int lower, List<List<Integer>> res, List<Integer> cur){
      if(lower != -1){
        cur.add(n);
        res.add(new ArrayList<Integer>(cur));
        cur.remove(cur.size() - 1);
      }

      int upper = (int)Math.sqrt(n);
      for(int i = Math.max(2, lower); i <= upper; i++){
        if(n % i == 0){
          cur.add(i);
          dfs(n/i, i, res, cur);
          cur.remove(cur.size() - 1);
        }
      }
    }
}
