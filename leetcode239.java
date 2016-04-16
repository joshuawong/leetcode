public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0)
            return new int[0];
        
        LinkedList<Integer> list = new LinkedList<>();
        
        int[] res = new int[nums.length - k + 1];
        
        for(int i = 0; i < nums.length; i++){
            while(!list.isEmpty() && nums[i] >= nums[list.getLast()]){
                list.removeLast();
            }
            list.add(i);
            if(i - list.getFirst() + 1 > k){
                // index larger than window size
                list.removeFirst();
            }
            if(i+1 >= k)
                res[i - k + 1] = nums[list.getFirst()];
        }
        return res;
    }
}
