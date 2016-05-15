/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
      if(intervals == null || intervals.length == 0)
        return 0;
      Arrays.sort(intervals, new Comparator<Interval>(){
        @Override
        public int compare(Interval a, Interval b){
          return a.start - b.start;
        }
      });

      PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, new Comparator<Interval>(){
        @Override
        public int compare(Interval a, Interval b){
          return a.end - b.end;
        }
      });

      heap.add(intervals[0]);

      for(int i = 1; i < intervals.length; i++){
        Interval tmp = heap.poll();

        if(intervals[i].start >= tmp.end){
          // current room can be used
          tmp.end = intervals[i].end;
        }
        else{
          // need a new meeting room
          heap.add(intervals[i]);
        }
        // put back the origin room.
        heap.add(tmp);
      }
      return heap.size();
    }
}
