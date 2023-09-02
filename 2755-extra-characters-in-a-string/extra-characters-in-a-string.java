class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n+1];// dp[i] represents the minimum extra characters up to position i

        for(int i=1; i<=n; i++){
            dp[i] = dp[i-1]+1; // Initialize dp[i] to be the maximum possible value
            for(String word : dictionary){
                int len = word.length();
                if(i >= len && s.substring(i - len, i).equals(word)){
                    dp[i] = Math.min(dp[i], dp[i-len]);
                }
            }
        }

        return dp[n];
    }
}