class Solution {
    public int countOrders(int n) {
        // Initialize a dp array to store the number of valid sequences for each n.
        long[] dp = new long[n+1];
        dp[1] = 1; // There is only one valid sequence for n = 1 (P1, D1).

        int mod = 1000000007;

        // Calculate the number of valid sequences for n from 2 to the given n.
        for(int i=2; i<=n; i++){
            // For each n, there are 2n-1 positions (pickup and delivery) to choose from.
            // The pickup and delivery for the new order can be placed in 2n-1 * 2n-2 ways.
            // But we also need to consider the previously calculated valid sequences for n-1.
            // So,the total number of valid sequences for n is dp[n-1] * (2n-1 * 2n-2).
            dp[i] = dp[i-1] * (2*i-1) * (2 * i)/2 % mod;
        }
        return (int) dp[n];

    }
}