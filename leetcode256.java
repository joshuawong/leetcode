/*
Solution: DP
Formula:
    for the i+1 house:
        curRed = min(lastGreen, lastBlue) + cost[i+1][0]
        curGreen = min(lastRed, lastBlue) + cost[i+1][1]
        curBlue = min(lastRed, lastGreen) + cost[i+1][2]
*/

public class Solution {
    public int minCost(int[][] costs) {
      if(costs == null || costs.length == 0)
        return 0;
      int lastRed = costs[0][0];
      int lastGreen = costs[0][1];
      int lastBlue = costs[0][2];
      for(int i = 0; i < costs.length; i++){
        int curRed = Math.min(lastGreen, lastBlue) + cost[i+1][0];
        int curGreen = Math.min(lastRed, lastBlue) + cost[i+1][1];
        int curBlue = Math.min(lastRed, lastGreen) + cost[i+1][2];

        int lastRed = curRed;
        int lastGreen = curGreen;
        int lastBlue = curBlue;
      }
      return Math.min(Math.min(lastRed, lastGreen), lastBlue);
    }
}
