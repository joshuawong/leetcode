/*
Solution: DFS
Time: O(kmn). Here k is the number of 0.
Space: O(1).
*/
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    dfs(rooms,i,j,0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int x, int y, int val){
        if(x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] < val){
            return;
        }
        rooms[x][y] = val;
        bfs(rooms, x-1, y, val+1);
        bfs(rooms, x+1, y, val+1);
        bfs(rooms, x, y-1, val+1);
        bfs(rooms, x, y+1, val+1);
    }
}
