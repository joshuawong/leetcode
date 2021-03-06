public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null)
            return res;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        q.add(s);
        visited.add(s);
        
        boolean found = false;
        
        while(!q.isEmpty()){
            s = q.poll();
            if(isValid(s)){
                res.add(s);
                found = true;
            }
            
            if(found)
                continue;
            
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != '(' && s.charAt(i) != ')'){
                    continue;
                }
                String sub = s.substring(0,i) + s.substring(i+1);
                if(!visited.contains(sub)){
                    q.add(sub);
                    visited.add(sub);
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')
                count++;
            if(c == ')' && count-- == 0)
                return false;
        }
        return count == 0;
    }
}
