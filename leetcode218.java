/*
Solution: Divide and Conquer
Reference: https://leetcode.com/discuss/40963/share-my-divide-and-conquer-java-solution-464-ms
*/
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings.length == 0)
            return new LinkedList<int[]>();
        return skyline(buildings, 0, buildings.length - 1);
    }
    
    private LinkedList<int[]> skyline(int[][] buildings, int l, int r){
        if(l < r){
            int mid = l + (r - l) / 2;
            return merge(skyline(buildings,l, mid), skyline(buildings, mid+1, r));
        }
        else{
            // only one building
            LinkedList<int[]> res = new LinkedList<>();
            // add the left-top point
            res.add(new int[]{buildings[l][0], buildings[l][2]});
            // add the right-bottom point
            res.add(new int[]{buildings[l][1], 0});
            return res;
        }
    }
    
    private LinkedList<int[]> merge(LinkedList<int[]> l1, LinkedList<int[]> l2){
        LinkedList<int[]> res = new LinkedList<>();
        int h1 = 0, h2 = 0;
        while(l1.size() > 0 && l2.size() > 0){
            int x = 0, h = 0;
            if(l1.getFirst()[0] < l2.getFirst()[0]){
                x = l1.getFirst()[0];
                h1 = l1.getFirst()[1];
                h = Math.max(h1, h2);
                l1.removeFirst();
            }
            else if(l1.getFirst()[0] > l2.getFirst()[0]){
                x = l2.getFirst()[0];
                h2 = l2.getFirst()[1];
                h = Math.max(h1, h2);
                l2.removeFirst();
            }
            else{
                x = l1.getFirst()[0];
                h1 = l1.getFirst()[1];
                h2 = l2.getFirst()[1];
                h = Math.max(h1, h2);
                l1.removeFirst();
                l2.removeFirst();
            }
            if(res.size() == 0 || h != res.getLast()[1]){
                res.add(new int[]{x, h});
            }
        }
        res.addAll(l1);
        res.addAll(l2);
        return res;
    }
    
    
    
    
}
