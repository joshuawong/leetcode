public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '+' && s.charAt(i-1) == '+'){
                String tmp = s.substring(0,i-1) + "--" + s.substring(i+1);
                res.add(tmp);
            }
        }
        return res;
    }
}