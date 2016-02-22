public class Solution {
	public String helper(String str){
		char c = str.charAt(0);
		StringBuffer res = new StringBuffer();
		int count = 1;
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == c){
				count++;
			}
			else{
				res.append(count);
				res.append(c);
				c = str.charAt(i);
				count = 1;
			}			
		}
		res.append(count);
		res.append(c);
		return res.toString();
	}

    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; ++i){
        	s = helper(s);
        }
        return s;
    }
}
