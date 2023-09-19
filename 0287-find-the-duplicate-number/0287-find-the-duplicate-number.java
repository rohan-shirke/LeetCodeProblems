class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length - 1;

        while(l<r){
            int m = (l+r)/2;
            int count = 0;

            // Count the number of elements in the array that are less than or equal to mid
            for(int num : nums){
                if(num <= m){
                    count++;
                }
            }
            // If there are more elements than mid, the duplicate is in the lower half
            if(count > m){
                r = m;
            }else{
                l = m+1;
            }
        }
        return l;
    }
}