public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] group = new int[n];
        for(int i = 0; i < n; i++){
            group[i] = i;
        }

        for(int[] edge : edges){
            int group1 = belong(edge[0], group);
            int group2 = belong(edge[1], group);
            if(group1 != group2){
                group[group1] = group2;
                n--;
            }
        }
        return n;
    }

    private int belong(int point, int[] group){
        while(group[point] != point){
            group[point] = group[group[point]];
            point = group[point];
        }
        return point;
    }
}
