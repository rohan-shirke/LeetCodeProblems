class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        
        if (!wordSet.contains(endWord)) {
            return 0; // The endWord is not in wordList, so no valid transformation sequence.
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1; // Initialize the level to 1 (beginWord is at level 1).
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                
                char[] wordChars = word.toCharArray();
                
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        
                        wordChars[j] = c; // Change one character of the word.
                        String newWord = new String(wordChars);
                        
                        if (newWord.equals(endWord)) {
                            return level + 1; // We found the endWord.
                        }
                        
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord); // Add the new word to the queue.
                            wordSet.remove(newWord); // Mark it as visited.
                        }
                    }
                    
                    wordChars[j] = originalChar; // Restore the original character.
                }
            }
            
            level++; // Move to the next level.
        }
        
        return 0; // No valid transformation sequence found.
    }
}