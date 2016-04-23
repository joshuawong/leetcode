public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null)
            return 0;
        int m = matrix.length,n;
        if(m == 0 || (n = matrix[0].length) == 0)
            return 0;
        
        int res = 0;
        int[] heights = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '0')
                    heights[j] = 0;
                else{
                    heights[j] += 1;
                }
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }
    
    private int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0: heights[i]);
            if(s.isEmpty() || h >= heights[s.peek()]){
                s.push(i);
            }
            else{
                int top = s.pop();
                maxArea = Math.max(maxArea, heights[top] * (s.isEmpty() ? i : i-1-s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
