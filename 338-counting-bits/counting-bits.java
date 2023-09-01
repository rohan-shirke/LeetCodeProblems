class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for(int i=1; i<=n; i++){
            // To count the number of 1s in the binary representation of i,
            // we can use the property that result[i] = result[i / 2] + (i % 2).
            result[i] = result[i>>1] + (i & 1);
        }

        return result;
    }
}