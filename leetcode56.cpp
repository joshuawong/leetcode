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

	int static comp(Interval t1, Interval t2)
	{
        int res = (t2.start > t1.start);
        return res;
    }

    vector<Interval> merge(vector<Interval>& intervals) {
        if(intervals.size() == 0 || intervals.size() == 1)
        	return intervals;
        vector<Interval> res;
        sort(intervals.begin(), intervals.end() , comp);
        int n = intervals.size();
        Interval tmp = intervals[0];
        // int inserted = 0;
        for (int i = 1; i < n; ++i)
        {
        	if(intervals[i].start <= tmp.end)
        	{
        		tmp.start = min(tmp.start,intervals[i].start);
        		tmp.end = max(tmp.end, intervals[i].end);
        	}
        	else if(intervals[i].start > tmp.end)
        	{
        		res.push_back(tmp);
        		// inserted = 1;
        		tmp = intervals[i];
        	}
        	/*else if(intervals[i].start > tmp.end && i == n-1)
        	{
        		res.push_back(tmp);
        		inserted = 1;
        		res.push_back(intervals[i]);
        	}*/
        }
        // if(inserted == 0)
        res.push_back(tmp);
        return res;
    }
};
