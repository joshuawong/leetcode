/*
Solution: use solution of Leetcode 304 Range Sum Query 2D - Immutable.
*/
public class NumMatrix {
    private int[][] sum;
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        this.matrix = matrix;

        int row = matrix.length;
        int col = matrix[0].length;
        sum = new int[row+1][col];

        for(int i = 1; i <= row; i++){
            for(int j = 0; j < col; j++){
                sum[i][j] = sum[i - 1][j] + matrix[i - 1][j];
            }
        }
    }

    public void update(int row, int col, int val) {
        for(int i = row+1; i < sum.length; i++){
            sum[i][col] = sum[i][col] - matrix[row][col] + val;
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
       int res = 0;
       for(int i = col1; i <= col2; i++){
           res += sum[row2+1][i] - sum[row1][i];
       }
       return res;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
