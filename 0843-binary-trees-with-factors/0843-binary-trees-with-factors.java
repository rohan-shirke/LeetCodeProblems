class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1000000007;
        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();
        long count = 0;

        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1L);
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (dp.containsKey(right)) {
                        dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.get(right)) % MOD);
                    }
                }
            }
            count = (count + dp.get(arr[i])) % MOD;
        }
        return (int) count;
    }
}