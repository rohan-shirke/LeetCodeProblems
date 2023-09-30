class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;// Variable to keep track of the number of non-zero elements
        // Iterate through the array and move non-zero elements to the beginning
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[count] = nums[i];
                count++;
            }
        }
        while(count < nums.length){
            nums[count] = 0;
            count++;
        }
    }
}