public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";
        String res = "";
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length;i++){
            str[i] = nums[i]+"";
        }
        
        Arrays.sort(str,new Comparator<String>(){
            @Override public int compare(String i, String j){
                String s1 = i+j;
                String s2 = j+i;
                return s1.compareTo(s2);
            }
        });
        if(str[nums.length-1].charAt(0) == '0')
            return "0";
        for(int i = 0; i < nums.length; i++){
            res = str[i] + res;
        }
        return res;
    }
}
