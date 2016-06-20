public class Solution {
    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int x1 = 0, x2 = s.length() - 1;
        while(x1 < x2){
            while(isVowels(cs[x1]) == false && x1 < x2)
                x1++;
            while(isVowels(cs[x2]) == false && x1 < x2)
                x2--;
            char tmp = cs[x1];
            cs[x1] = cs[x2];
            cs[x2] = tmp;
            x1++;
            x2--;
        }
        return new String(cs);
    }

    private boolean isVowels(char a){
        if(a == 'e' || a == 'o' || a == 'u' || a == 'a' || a == 'i')
            return true;
        else if(a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U')
            return true;
        else
            return false;
    }
}
