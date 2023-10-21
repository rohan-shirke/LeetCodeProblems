class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] stores the maximum sum of subsequence ending at index i
        int result = nums[0]; // Initialize the result as the first element
        Deque<Integer> deque = new ArrayDeque<>(); // Using deque for efficient operations

        for (int i = 0; i < n; i++) {
            // Calculate the maximum sum based on the condition j - i <= k
            int maxSum = deque.isEmpty() ? 0 : Math.max(0, dp[deque.peekFirst()]);

            // Calculate the sum considering the maximum sum obtained so far
            dp[i] = nums[i] + maxSum;

            // Update the result if necessary
            result = Math.max(result, dp[i]);

            // Update the deque by removing unnecessary elements from the end
            while (!deque.isEmpty() && dp[i] > dp[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add the current index to the deque if the sum is positive
            if (dp[i] > 0) {
                deque.offerLast(i);
            }

            // Remove the elements from the front of the deque if they are out of range
            if (!deque.isEmpty() && i - deque.peekFirst() + 1 > k) {
                deque.pollFirst();
            }
        }

        return result; // Return the maximum sum
    }
}