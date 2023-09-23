class Solution {
    public int longestStrChain(String[] words) {
        // Sort the words by their lengths
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        // Create a map to store the length of the longest chain ending with each word
        Map<String, Integer> dp = new HashMap<>();
        int maxChainLength = 1;

        for (String word : words) {
            int currentChainLength = 1;

            // Generate all possible predecessors of the current word
            for (int i = 0; i < word.length(); i++) {
                StringBuilder predecessor = new StringBuilder(word);
                predecessor.deleteCharAt(i);
                String predStr = predecessor.toString();

                // Check if the predecessor exists in the map
                if (dp.containsKey(predStr)) {
                    currentChainLength = Math.max(currentChainLength, dp.get(predStr) + 1);
                }
            }

            // Update the maximum chain length for the current word
            dp.put(word, currentChainLength);
            maxChainLength = Math.max(maxChainLength, currentChainLength);
        }

        return maxChainLength;
    }
}