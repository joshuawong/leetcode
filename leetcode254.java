/*
Solution: DFS + Backtracking
Time: O()
Space: O(1)
Runtime: 234ms
*/

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), n, 2);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int n, int start){
      if(n <= 1){
        if(cur.size() > 1){
          res.add(new ArrayList<Integer>(cur));
        }
        return;
      }
      for(int i = start; i <= n ; i++){
        if(n % i == 0){
          cur.add(i);
          dfs(res,cur,n/i,i);
          cur.remove(cur.size() - 1);
        }
      }
    }
}
