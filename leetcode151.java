public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] tmp =s.split(" +");;
        for(int i = 0; i < tmp.length / 2; i++)
		{
		    String temp = tmp[i];
		    tmp[i] = tmp[tmp.length - i - 1];
		    tmp[tmp.length - i - 1] = temp;
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < tmp.length; i++){
			sb.append(tmp[i]+" ");
		}
		return sb.toString().trim();
    }
}
