public class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len1 < len2)
        	return -1;
        else if(len2 == 0)
        	return 0;
        int index = -1;
        for(int i = 0; i <= len1-len2; i++){
        	if(needle.equals(haystack.substring(i,i+len2)) == true){
        		index = i;
        		break;
        	}
        }
        return index;
    }
}
