public class Solution {
    public void reverseWords(char[] s) {
      reverse(s, 0, s.length - 1);
      int index = 0;
      for(int i = 0; i < s.length; i++){
        if(s[i] == ' '){
          reverse(s, index, i-1);
          index = i + 1;
        }
      }
      reverse(s, index, s.length - 1);
    }

    private void reverse(char[] nums, int start, int end){
      while(start < end){
        char tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
        start++;
        end--;
      }
    }
}
