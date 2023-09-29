class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;// Assume it's initially increasing
        boolean decreasing = true;// Assume it's initially decreasing

        // Iterate through the array
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                decreasing = false;// If we find an increasing pair, it's not decreasing
            }else if(nums[i] < nums[i-1]){
                increasing = false;// If we find a decreasing pair, it's not increasing
            }

        }
        return increasing || decreasing;
    }
}