public class Solution {
    public int compareStr(String i, String j){
        String s1 = i+j;
        String s2 = j+i;
        return s1.compareTo(s2);
    }
    public void swap(String[] str,int x, int y){
        String tmp = str[x];
        str[x] = str[y];
        str[y] = tmp;
    }
    
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";
        String res = "";
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length;i++){
            str[i] = nums[i]+"";
        }
        
        for(int i = 0; i < nums.length-1;i++){
            for(int j = i+1;j< nums.length;j++){
                if(compareStr(str[i],str[j]) > 0){
                    swap(str,i,j);
                }
            }
        }
        if(str[nums.length-1].charAt(0) == '0')
            return "0";
        for(int i = 0; i < nums.length; i++){
            res = str[i] + res;
        }
        return res;
    }
}
