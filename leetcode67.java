public class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length()-1;
        int len2 = b.length()-1;
        int c = 0;
        StringBuffer sb = new StringBuffer();
        while(len1 >= 0 || len2 >= 0){
        	int tmp = c;
        	if(len1 >= 0){
        		tmp += a.charAt(len1--) - '0';
        	}
        	if(len2 >= 0){
        		tmp += b.charAt(len2--) - '0';
        	}
        	sb.append(tmp%2);
        	c = tmp / 2;
        }
        if(c != 0)
        	sb.append(c);
        return sb.reverse().toString();

    }
}
