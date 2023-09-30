class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        if(n<3){
            return false;// The pattern requires at least 3 elements.
        }

        int[] minArray = new int[n];// To store the minimum element up to the current index.

        minArray[0] = nums[0];

        for(int i=1; i<n; i++){
            minArray[i] = Math.min(minArray[i-1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();// To store potential candidates for '2'.

        for(int j = n-1; j>=0; j--){
            if(nums[j] > minArray[j]){// If nums[j] is greater than its minimum on the left.

            while(!stack.isEmpty() && stack.peek() <= minArray[j]){
                stack.pop();// Remove elements that are smaller or equal to minArray[j].
            }

            if(!stack.isEmpty() && stack.peek() < nums[j]){
                return true; // If there's an element greater than minArray[j] but smaller than nums[j].
            }
            stack.push(nums[j]); // Push nums[j] as a potential candidate for '2'.
            }
        }
        return false;
    }
}