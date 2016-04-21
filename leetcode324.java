public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        mid = mid + ((nums.length % 2 == 0) ? 0 : 1);
        int[] smallPart = Arrays.copyOfRange(nums,0,mid);
        int[] largePart = Arrays.copyOfRange(nums,mid,nums.length);
        
        int i = smallPart.length-1;
        int j = largePart.length - 1;
        int k = 0;
        while(i >= 0 && j >= 0){
            nums[k] = smallPart[i];
            nums[k+1] = largePart[j];
            i--;
            j--;
            k+=2;
        }
        if(i >= 0)
        	nums[k] = smallPart[i];
    }
}
