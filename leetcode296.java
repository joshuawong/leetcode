//二维的等于一维的相加, 一维的最小点必在median点(用反证法可以证明).
/*
Solution: Math
Time: O(mn)
*/
public class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for(int i = 0; i < m; i++){
          for(int j = 0; j < n; j++){
            if(grid[i][j] == 1){
              x.add(i);
              y.add(j);
            }
          }
        }
        return getMedian(x) + getMedian(y);
    }

    private int getMedian(List<Integer> list){
      Collections.sort(list);
      int res = 0;
      int l = 0;
      int r = list.size() - 1;
      while(l < r){
        res += list.get(r) - list.get(l);
        l++;
        r--;
      }
      return res;
    }
}
