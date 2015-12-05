class Solution {
public:
	int FindKth(vector<int>& nums1, int al, int ar, vector<int>& nums2, int bl, int br, int k)
	{
		if(al > ar)	return nums2[bl+k-1];
		if(bl > br) return nums1[al+k-1];
		int amid = (al+ar)/2;
		int bmid = (bl+br)/2;
		if(nums1[amid] <= nums2[bmid])
		{
			if(k <= (amid-al)+(bmid-bl)+1)
				return FindKth(nums1,al,ar,nums2,bl,bmid-1,k);
			else
				return FindKth(nums1,amid+1,ar,nums2,bl,br,k-(amid-al)-1);
		}
		else
		{
			if(k <= (amid-al)+(bmid-bl)+1)
				return FindKth(nums1,al,amid-1,nums2,bl,br,k);
			else
				return FindKth(nums1,al,ar,nums2,bmid+1,br,k-(bmid-bl)-1);
		}
	}

    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        int k = (m + n + 1) / 2;
        double v = (double)FindKth(nums1,0,m-1,nums2,0,n-1,k);
        if((m+n)%2 == 0)
        {
        	int k2 = k + 1;
        	double v2 = (double)FindKth(nums1,0,m-1,nums2,0,n-1,k2);
        	v = (v+v2) / 2;
        }
        return v;
    }
};
