class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n];

        // Initialize the first element of arr
        arr[0] = pref[0];

        // Use XOR operation to find the subsequent elements
        for (int i = 1; i < n; i++) {
            arr[i] = pref[i] ^ pref[i - 1];
        }

        return arr;
    }
}