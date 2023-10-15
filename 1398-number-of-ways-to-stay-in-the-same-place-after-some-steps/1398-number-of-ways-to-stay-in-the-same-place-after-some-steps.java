class Solution {
    public int numWays(int steps, int arrLen) {
       int mod = 1000000007;
        int maxCol = Math.min(steps, arrLen - 1);
        int[][] dp = new int[steps + 1][maxCol + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxCol; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
                if (j + 1 <= maxCol) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
            }
}
        return dp[steps][0];
    }
}