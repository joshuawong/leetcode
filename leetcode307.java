/*
Solution: Segment tree
Time: for update: O(lgN)
Space: for update: O(2N)
*/
public class NumArray {
    public class SegmentTreeNode{
        int start = 0;
        int end = 0;
        int sum = 0;
        
        SegmentTreeNode left = null;
        SegmentTreeNode right = null;
        
        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    private SegmentTreeNode root = null;
    // private int[] data = null;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    private SegmentTreeNode buildTree(int[] nums, int start, int end){
        if(start > end)
            return null;
        else{
            SegmentTreeNode res = new SegmentTreeNode(start, end);
            if(start == end)
                res.sum = nums[start];
            else{
                int mid = (start + end) / 2;
                res.left = buildTree(nums, start, mid);
                res.right = buildTree(nums, mid+1, end);
                res.sum = res.left.sum + res.right.sum;
            }
            return res;
        }
    }

    void update(int i, int val) {
        update(root, i , val);
    }
    
    private void update(SegmentTreeNode root, int pos, int val){
        if(root.start == root.end)
            root.sum = val;
        else{
            int mid = (root.start + root.end) / 2;
            if(pos <= mid){
                update(root.left, pos, val);
            }
            else{
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(SegmentTreeNode root, int start, int end){
        if(root.end == end && root.start == start)
            return root.sum;
        else{
            int mid = (root.start + root.end) / 2;
            if(end <= mid){
                return sumRange(root.left, start, end);
            }
            else if(start >= mid+1){
                return sumRange(root.right, start, end);
            }
            else{
                return sumRange(root.left, start, mid) + sumRange(root.right, mid+1, end);
            }
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
