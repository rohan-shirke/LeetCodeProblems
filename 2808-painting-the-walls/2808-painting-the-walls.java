class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, (int) 1e9);// Filling the array with a very large value to simulate infinity(1 followed by 9 zeros)
        dp[0] = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = n; j > 0; --j) {
                // Update the minimum cost for painting j walls
                // by taking the minimum between the current cost of painting j walls
                // and the cost of painting (j - time[i] - 1) walls, plus the cost of painting the current wall
                dp[j] = Math.min(dp[j], dp[Math.max(j - time[i] - 1, 0)] + cost[i]);
            }
        }
        return dp[n];
    }
}

// TC:O(n^2)
// SC:O(N)