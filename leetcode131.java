public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s.length() == 0){
            return res;
        }
        dfs(res,new ArrayList<String>(),s);
        return res;
    }
    
    private void dfs(List<List<String>> res, List<String> path, String s){
        if(s.length() == 0){
            res.add(new ArrayList<String>(path));
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(isPalindrome(s, 0, i)){
                path.add(s.substring(0,i+1));
                dfs(res,path,s.substring(i+1));
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
