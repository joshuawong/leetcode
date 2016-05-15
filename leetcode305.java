/*
Solution: Union Find
Time: O(logn)
Space: O(m*n)
*/

public class Solution {
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
      List<Integer> res = new ArrayList<>();
      if(m <= 0 || n <= 0)
        return res;

      int count = 0;
      int[] roots = new int[m*n];
      Arrays.fill(roots,-1);

      for(int[] position : positions){
        int root = n*position[0] + position[1];
        roots[root] = root;
        count++;

        for(int[] direction : directions){
          int x = position[0] + direction[0];
          int y = position[1] + direction[1];
          int newRoot = n * x + y;
          if(x < 0 || x >= m || y < 0 || y >= n || roots[newRoot] == -1)
            continue;

          int rootOfnew = findIsland(roots, newRoot);
          if(root != rootOfnew){
            roots[root] = rootOfnew;
            root = rootOfnew;
            count--;
          }
        }
        res.add(count);
      }
      return res;
    }

    private int findIsland(int[] roots, int index){
      while(index != roots[index]){
        index = roots[index];
      }
      return index;
    }
}
