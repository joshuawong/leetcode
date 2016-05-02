/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if(buf == null || buf.length == 0 || n == 0)
            return 0;
        boolean eof = false;
        int sum = 0;
        char[] tmp = new char[4];

        while(!eof && sum < n){
            int num = read4(tmp);
            eof = num != 4 ? true : false;

            num = Math.min(num, n - sum);

            for(int i = 0; i < num; i++){
                buf[sum++] = tmp[i];
            }
        }
        return sum;
    }
}
