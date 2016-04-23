public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0)
            return "";
        
        int[] S = new int[256];
        int[] T = new int[256];
        for(int i = 0; i < t.length(); i++){
            T[t.charAt(i)]++;
        }
        
        int found = 0; // found = 0 ~ 3
        int len = Integer.MAX_VALUE;
        String res = "";
        int i = 0;
        int start = 0;
        while(i < s.length()){
            if(found < t.length()){
                if(T[s.charAt(i)] > 0){ // find a char in t
                    S[s.charAt(i)]++;
                    if(S[s.charAt(i)] <= T[s.charAt(i)]){ // if this char appear first time, found+1; if duplicate, ignore. 
                        found++;
                    }
                }
                i++;
            }
            while(found == t.length()){ // find all char in string t
                if(i - start < len){
                    len = i - start;
                    res = s.substring(start,i); // store temperal result
                }
                if(T[s.charAt(start)] > 0){ // remove the first char
                    S[s.charAt(start)]--;
                    if(S[s.charAt(start)] < T[s.charAt(start)]){
                        found--; // because this char in string t, so found-1
                    }
                }
                start++;
            }
        }
        return res;
    }
}
