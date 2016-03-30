public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return Collections.singletonList(0);
        }
        
        // use for storing adj table
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            adj.put(i,new HashSet<Integer>());
        }
        
        // store adj table
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(adj.get(i).size() == 1){
                leaves.add(i);
            }
        }
        
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves){
                for(int newleaf : adj.get(leaf)){
                    adj.get(leaf).remove(newleaf);
                    adj.get(newleaf).remove(leaf);
                    if(adj.get(newleaf).size() == 1){
                        newLeaves.add(newleaf);
                    }
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
