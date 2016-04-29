/*
Solution: backtracking with memo
*/
public class Solution {
    public boolean canWin(String s) {
        Map<String, Boolean> memo = new HashMap<>();
        return canWinRec(s, memo);
    }

    private boolean canWinRec(String s, Map<String, Boolean> memo){
        if(memo.containsKey(s))
            return memo.get(s);

        for(int i = 0; i < s.length() - 1; i++){
            if(s.startsWith("++",i)){
                String tmp = s.substring(0,i) + "--" + s.substring(i+2);
                if(canWinRec(tmp, memo) == true)
                    continue;
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
