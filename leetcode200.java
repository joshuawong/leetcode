// word search solution
public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    searchIsland(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void searchIsland(char[][] grid, int x, int y){
        // search one island
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0'){
            return;
        }
        grid[x][y] = '0';
        searchIsland(grid,x-1,y);
        searchIsland(grid,x+1,y);
        searchIsland(grid,x,y-1);
        searchIsland(grid,x,y+1);
    }
}
