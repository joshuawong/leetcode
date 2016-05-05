/*
Solution: dfs
Time: O(col*row). 邻接矩阵DFS从一个点出发，一次DFS时间复杂度为O(col*row), 此题只需要从一个点发出.
Space: O(1). constant space res[4]
*/

public class Solution {
    public int minArea(char[][] image, int x, int y) {
      int m = image.length;
      if(m == 0)
        return 0;
      int n = image[0].length;
      int[] res = new int[4];  // up down left right
      res[0] = m - 1;
      res[1] = 0;
      res[2] = n - 1;
      res[3] = 0;
      dfs(image, x, y, res);
      return (res[1] - res[0] + 1) * (res[3] - res[2] + 1);
    }

    private void dfs(char[][] image, int x, int y, int[] res){
      int col = image.length;
      int row = image[0].length;
      if(x < 0 || x >= col || y < 0 || y >= row)
        return;
      if(image[x][y] == '0')
        return;
      image[x][y] = '0';

      if(x < res[0]) res[0] = x;
      if(x > res[1]) res[1] = x;
      if(y < res[2]) res[2] = y;
      if(y > res[3]) res[3] = y;

      dfs(image, x+1, y, res);
      dfs(image, x, y+1, res);
      dfs(image, x-1, y, res);
      dfs(image, x, y-1, res);
    }
}
