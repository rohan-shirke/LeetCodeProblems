class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m>n){// Ensure nums1 is always the smaller array
            int[] temp= nums1;
            nums1 = nums2;
            nums2 = temp;
            int tempSize = m;
            m=n;
            n=tempSize;
        }
        
        int left = 0;
        int right = m;
        int halfLen = (m+n+1)/2;

        while(left<=right){
            int mid = (left+right)/2;
            int j = halfLen-mid;

            if(mid < m && nums2[j-1]>nums1[mid]){
                left = mid + 1;// i is too small, increase it
            }else if(mid > 0 && nums1[mid-1]>nums2[j]){
                right = mid-1;// i is too big, decrease it
            } else{ // i is perfect
                int maxLeft;
                if(mid==0){
                    maxLeft = nums2[j-1];
                }else if(j==0){
                    maxLeft=nums1[mid-1];
                }else{
                    maxLeft = Math.max(nums1[mid-1], nums2[j-1]);
                }

                if((m+n)%2==1){
                    return maxLeft;
                }

                int minRight;
                if(mid==m){
                    minRight = nums2[j];
                }else if(j==n){
                    minRight=nums1[mid];
                }else{
                    minRight = Math.min(nums1[mid], nums2[j]);
                }
                return (maxLeft + minRight)/2.0;
            }
        }
        return 0.0;
    }
}