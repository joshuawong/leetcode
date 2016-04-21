/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
/*
Solution: BFS
Time: O(n)
Space: O(n)
*/
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node, copyNode);
        while(!q.isEmpty()){
            UndirectedGraphNode tmp = q.poll();
            for(UndirectedGraphNode neighbor : tmp.neighbors){
                if(map.containsKey(neighbor)){
                    map.get(tmp).neighbors.add(map.get(neighbor));
                }
                else{
                    // create a new copy of neigbor
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.get(tmp).neighbors.add(neighborCopy);
                    map.put(neighbor, neighborCopy);
                    q.add(neighbor);
                }
            }
        }
        return copyNode;
    }
}
