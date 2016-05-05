/*
Soultion: Binary Search
Time: O(m log n + n log m).
    To determine if a column vector has a black pixel is O(m) so the search in total is O(m log n)
    We can do the same for the other boundaries. The area is then calculated by the boundaries.
    Thus the algorithm runs in O(m log n + n log m)
Spcae: O(1). four variable
*/
public class Solution {
    public int minArea(char[][] image, int x, int y) {
      int m = image.length;
      if(m == 0)
        return 0;
      int n = image[0].length;
      int colMin = binarySearch(image, true, 0, y, 0, m, true);
      int colMax = binarySearch(image, true, y+1, n,0, m, false);
      int rowMin = binarySearch(image, false, 0, x , colMin, colMax, true);
      int rowMax = binarySearch(image, false, x+1, m, colMin, colMax, false);
      return (rowMax - rowMin) * (colMax - colMin);
    }

    private int binarySearch(char[][] image, boolean horizontal, int lower, int upper, int min, int max, boolean goLower) {
        while(lower < upper) {
            int mid = lower + (upper - lower) / 2;
            boolean inside = false;
            for(int i = min; i < max; i++) {
                if((horizontal ? image[i][mid] : image[mid][i]) == '1') {
                    inside = true;
                    break;
                }
            }
            if(inside == goLower) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        return lower;
    }
}
