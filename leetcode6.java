public class Solution {
    public String convert(String s, int numRows) {
        char c[] = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < numRows ;++i) {
        	sb[i] = new StringBuffer();
        }

        int i = 0;
        while(i < len){
        	for(int j = 0; j < numRows && i < len; ++j){
        		sb[j].append(c[i]);
        		i++;
        	}
        	for(int j = numRows-2; j >= 1 && i < len; --j){
        		sb[j].append(c[i]);
        		i++;
        	}
        }
        String res = "";
        for (int m = 0;m < sb.length ;m++ ) {
        	res += sb[m];
        }
        return res;
    }
}
