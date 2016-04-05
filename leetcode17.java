public class Solution {
    private static final String[] refer = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuffer s = new StringBuffer();
        if(!digits.equals("")){
            backtrack(res,digits, s, 0);
            return res;
        }
        return res;
    }
    
    private void backtrack(List<String> res, String digits, StringBuffer s, int start){
        // end condition
        if(start == digits.length()){
            res.add(s.toString());
            return;
        }
        String tmp = refer[digits.charAt(start) - '0'];
        for(int i = 0; i < tmp.length(); i++){
            s.append(tmp.charAt(i));
            backtrack(res,digits,s,start+1);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
