/*
Solution: Backtracking
*/
public class Solution {
    public boolean canWin(String s) {
        if(s == null || s.length() == 0)
            return false;

        for(int i = 0; i < s.length()-1; i++){
            if(s.startsWith("++", i)){
                String tmp = s.substring(0,i) + "--" + s.substring(i+2);
                if(!canWin(tmp))
                    return true;
            }
        }
        return false;
    }
}
