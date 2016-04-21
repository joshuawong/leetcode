/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
/*
Solution: DFS
Time: O(n)
Space: O(n)
*/
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return DFS(node,map);
    }
    
    private UndirectedGraphNode DFS(UndirectedGraphNode node, Map<UndirectedGraphNode,UndirectedGraphNode> map){
        if(map.containsKey(node)){
            return map.get(node);
        }
        
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node, copyNode);
        for(UndirectedGraphNode neighbor : node.neighbors){
            copyNode.neighbors.add(DFS(neighbor, map));  // recursive
        }
        return copyNode;
    }
}
