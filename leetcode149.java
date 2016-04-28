/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int size = points.length;
        int max = 0;
        
        if(size <= 2)
            return size;
        
        for(int i = 0; i < size; i++){
            Map<Double, Integer> map = new HashMap<>();
            int sameX = 1;
            int sameP = 0;
            
            for(int j = 0; j < size; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        sameP++;
                    }
                    if(points[j].x == points[i].x){
                        sameX++;
                        continue;
                    }
                    double slope = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    if(map.containsKey(slope)){
                        map.put(slope,map.get(slope) + 1);
                    }else{
                        map.put(slope, 2);
                    }
                    max = Math.max(max, map.get(slope)+sameP);
                    
                }
            }
            max = Math.max(max, sameX);            
        }
        return max;
    }
}
