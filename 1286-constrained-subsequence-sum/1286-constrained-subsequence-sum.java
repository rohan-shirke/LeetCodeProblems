class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int result = nums[0];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int maxSum = deque.isEmpty() ? 0 : Math.max(0, dp[deque.peekFirst()]);
            dp[i] = nums[i] + maxSum;
            result = Math.max(result, dp[i]);

            while (!deque.isEmpty() && dp[i] > dp[deque.peekLast()]) {
                deque.pollLast();
            }

            if (dp[i] > 0) {
                deque.offerLast(i);
            }

            if (!deque.isEmpty() && i - deque.peekFirst() + 1 > k) {
                deque.pollFirst();
            }
        }

        return result;
    }
}