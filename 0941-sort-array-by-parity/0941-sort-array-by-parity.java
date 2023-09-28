class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int evenIndex = 0;
        int oddIndex = nums.length-1;

        for(int num : nums){
            if(num % 2 == 0){
                // If the number is even, place it at the beginning
                result[evenIndex] = num;
                evenIndex++;
            }else{
                // If the number is odd, place it at the end
                result[oddIndex] = num;
                oddIndex--;
            }
        }
        return result;
    }
}