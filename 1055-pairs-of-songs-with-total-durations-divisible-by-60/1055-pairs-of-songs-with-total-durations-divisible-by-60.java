class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // Create a HashMap to count the songs with remainders when divided by 60
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for(int t : time){
            int rem = t%60;
            // Calculate the complement remainder needed for the sum to be divisible by 60
            int complement = (60 - rem) % 60;

            // If the complement remainder exists in the HashMap, increment the result
            result += map.getOrDefault(complement, 0);
            // Update the count of the current remainder
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return result;
    }
}

// class Solution {
//     public int numPairsDivisibleBy60(int[] time) {
//         int[] count = new int[60];

//         int result = 0;

//         for(int t : time){
//             int complement = (60 - (t % 60)) % 60;
//             result += count[complement];
//             count[t %60]++;
//         }

//         return result;
//     }
// }