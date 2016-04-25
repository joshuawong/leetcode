/*
Solution: DFS
*/
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res, num, target, 0, 0, "");
        return res;
    }
    
    private void dfs(List<String> res, String num, int target, long cur, long diff, String tmp){
        if(cur == target && num.length() == 0)
            res.add(tmp);
        
        for(int i = 1; i <= num.length(); i++){
            String curr = num.substring(0,i);
            String next = num.substring(i);
            if(curr.charAt(0) == '0' && curr.length() > 1)
                return;
            if(tmp.length() > 0){
                dfs(res, next, target, Long.parseLong(curr)+cur, Long.parseLong(curr), tmp+"+"+curr);
                dfs(res, next, target, cur-Long.parseLong(curr), -Long.parseLong(curr), tmp+"-"+curr);
                dfs(res, next, target, cur-diff+diff*Long.parseLong(curr), diff*Long.parseLong(curr), tmp+"*"+curr);
            }
            else{
                dfs(res, next, target, Long.parseLong(curr), Long.parseLong(curr), curr);
            }
        }
    }
}
