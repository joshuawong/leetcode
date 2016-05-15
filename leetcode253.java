/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/*
Time: O(n) two-pass
Space: O(2n). two new arrays
*/

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
      int n = intervals.length;
      int[] start = new int[n];
      int[] end = new int[n];
      for(int i = 0; i < n; i++){
        start[i] = intervals[i].start;
        end[i] = intervals[i].end;
      }

      Arrays.sort(start);
      Arrays.sort(end);
      int result = 0;
      int endIndex = 0;
      for(int i = 0; i < n; i++){
        if(start[i] < end[endIndex])
          result++;
        else
          endIndex++;
      }
      return result;
    }
}
