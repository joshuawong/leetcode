public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if(tickets == null || tickets.length == 0)
            return res;
            
        Map<String, ArrayList<String>> graph = new HashMap<>();
        for(String[] ticket : tickets){
            if(!graph.containsKey(ticket[0])){
                ArrayList<String> adj = new ArrayList<>();
                adj.add(ticket[1]);
                graph.put(ticket[0],adj);
            }
            else{
                ArrayList<String> newAdj = graph.get(ticket[0]);
                newAdj.add(ticket[1]);
                graph.put(ticket[0],newAdj);
            }
        }
        
        for(ArrayList<String> value : graph.values()){
            Collections.sort(value);
        }
        
        backtracking(res, "JFK", graph);
        
        return res;
    }
    
    private void backtracking(List<String> res, String curr, Map<String, ArrayList<String>> graph){
        while(graph.containsKey(curr) && !graph.get(curr).isEmpty()){
            String s = graph.get(curr).remove(0);
            backtracking(res, s, graph);
        }
        res.add(0,curr);
    }
}
