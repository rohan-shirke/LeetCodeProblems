class Solution {
    public int minDeletions(String s) {
        // Initialize a hashmap to store character frequencies
        Map<Character, Integer> map = new HashMap<>();

        // Count the frequency of each character in the string
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        // Initialize a set to keep track of used frequencies
        Set<Integer> set = new HashSet<>();

        int result = 0;

        // Iterate through the character frequencies
        for(int freq : map.values()){
            while(set.contains(freq)){
                // If the frequency is already used, decrement it and increase deletions
                freq--;
                // If freq becomes negative, we can't use it anymore
                if(freq < 0){
                    break;
                }
                result++;
            }

            // Add the frequency to the used frequencies set if it's still positive
            if(freq > 0){
                set.add(freq);
            }
            

        }
        return result;
    }
}