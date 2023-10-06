class Solution {
    public int integerBreak(int n) {
        if(n <= 1){
            return 0;// Return 0 for n <= 1 as we can't break it into positive integers.
        }
        // Create an array to store the maximum product for each number from 0 to n.
        int[] dp = new int[n+1];
        // Initialize dp array for base cases.
        dp[1] = 1;
        dp[2] = 1;

        // Calculate maximum product for each number from 3 to n.
        for(int i=3; i<=n; i++){
            for(int j=1; j<i; j++){
                // Find the maximum product by breaking i into j and (i - j),
                // and compare it with the current maximum product for i.

                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];


    }
}