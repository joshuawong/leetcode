public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        
        for(int i = Math.max(k-n, 0); i <= Math.min(m,k); i++){
            int[] sub1 = getMaxArray(nums1, i);
            int[] sub2 = getMaxArray(nums2, k - i);
            int[] sub = new int[k];
            int pos1 = 0, pos2 = 0, pos = 0;
            
            while(pos1 < sub1.length || pos2 < sub2.length){
                sub[pos++] = compareArray(sub1, pos1, sub2, pos2) ? sub1[pos1++] : sub2[pos2++];
            }
            
            if(!compareArray(res, 0, sub, 0)){
                res = sub;
            }
        }
        return res;
    }
    
    private int[] getMaxArray(int[] nums, int k){
        int[] res = new int[k];
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            while(len > 0 && len + nums.length-i > k && res[len-1] < nums[i]){
                len--;
            }
            if(len < k){
                res[len] = nums[i];
                len++;
            }
        }
        return res;
    }
    
    private boolean compareArray(int[] nums1, int start1, int[] nums2, int start2){
        while(start1 < nums1.length && start2 < nums2.length){
            if (nums1[start1] > nums2[start2]) 
                return true;
            if (nums1[start1] < nums2[start2]) 
                return false;
            start1++;
            start2++;
        }
        return start1 != nums1.length;
    }
}
