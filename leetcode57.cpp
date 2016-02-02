/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
       
       vector<Interval> res;
       int inserted = 0;
 	   if(intervals.empty() == true)
 	   {
 	   		res.push_back(newInterval);
 	   		return res;
 	   }
       for (int i = 0; i < intervals.size(); ++i)
       {
       		//Interval tmp;
       		if(intervals[i].end < newInterval.start)   //case no-merge
       		{
       			res.push_back(intervals[i]);
       		}
       		else if(intervals[i].start > newInterval.end)
       		{
       			if(inserted == 0)
       			{
       				res.push_back(newInterval);
       				inserted = 1;
       			}
       			res.push_back(intervals[i]);
       		}
       		else
       		{
       			newInterval.start = min(intervals[i].start,newInterval.start);
       			newInterval.end = max(intervals[i].end, newInterval.end);
       			
       		}
       		/*else if(intervals[i].start < newInterval.start && intervals[i].end < newInterval.end) //case front-merge
       		{
       			newInterval.start = intervals[i].start;
       		}
       		else if(intervals[i].start > newInterval.start && intervals[i].end < newInterval.end) //case all-merge
       		{
       			continue;
       		}
       		else if(intervals[i].start > newInterval.start && intervals[i].end > newInterval.end) //case back-merge
       		{
       			newInterval.end = intervals[i].end;
       		}
       		else if(intervals[i].start > newInterval.end)
       		{
       			res.push_back(newInterval);
       			inserted = 1;
       			res.push_back(intervals[i]);
       		}
       		else if(intervals[i].start < newInterval.start && intervals[i].end > newInterval.end)
       		{
       			res.push_back(intervals[i]);
       			inserted = 1;
       		}*/
       }
       if(inserted == 0)
       		res.push_back(newInterval);
       return res;
    }
};
