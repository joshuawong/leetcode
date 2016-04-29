public class Solution {
    public boolean canWin(String s) {
        List<String> lists = new ArrayList<>();

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '+' && s.charAt(i-1) == '+'){
                String tmp = s.substring(0,i-1) + "--" + s.substring(i+1);
                lists.add(tmp);
            }
        }

        for(String list : lists){
            if(!canWin(list))
                return true;
        }
        return false;
    }
}
