class Solution {
    public int numIdenticalPairs(int[] nums) {
        // Initialize a hashmap to count the occurrences of each number
        Map<Integer, Integer> map = new HashMap<>();
        // Initialize a hashmap to count the occurrences of each number
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int goodPairs = 0;

        // Calculate good pairs for each number in the hashmap
        for(int count : map.values()){
            goodPairs += count * (count - 1) / 2;
        }
        return goodPairs;

    }
}