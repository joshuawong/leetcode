public class Solution {
    public int shortestDistance(int[][] grid) {
      int row =grid.length;
      final int[] shift = new int[]{0,1,0,-1,0};
      if(row == 0)
        return -1;
      int col = grid[0].length;
      int[][] reach = new int[row][col];
      int[][] distance = new int[row][col];
      int numOfBuilding = 0;

      for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
          if(grid[i][j] == 1){
            numOfBuilding++;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{i,j});

            boolean[][] isVisited = new boolean[row][col];
            int level = 1;

            while(!q.isEmpty()){
              int queueLen = q.size();
              for(int k = 0; k < queueLen; k++){
                int[] cur = q.poll();
                for(int x = 0; x < 4; x++){
                  int nextRow = cur[0] + shift[x];
                  int nextCol = cur[1] + shift[x+1];

                  if(nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]){
                      distance[nextRow][nextCol] += level;
                      reach[nextRow][nextCol]++;

                      isVisited[nextRow][nextCol] = true;
                      q.add(new int[]{nextRow, nextCol});
                  }
                }
              }
              level++;
            }
          }
        }
      }
      int shortestDistance = Integer.MAX_VALUE;
      for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
          if(grid[i][j] == 0 && reach[i][j] == numOfBuilding){
            shortestDistance = Math.min(shortestDistance, distance[i][j]);
          }
        }
      }
      return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
    }
}
