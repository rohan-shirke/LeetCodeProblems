class Solution {
    public String smallestSubsequence(String s) {
        int[] lastOccurrence = new int[26];
        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack<>();

        // Populate the last occurrence index for each character in the string.
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the character is already used, skip it.
            if (used[currentChar - 'a']) {
                continue;
            }

            // Remove characters from the stack that are greater than the current character
            // and still have occurrences remaining in the string.
            while (!stack.isEmpty() && currentChar < stack.peek() && i < lastOccurrence[stack.peek() - 'a']) {
                used[stack.pop() - 'a'] = false;
            }

            // Add the current character to the stack and mark it as used.
            stack.push(currentChar);
            used[currentChar - 'a'] = true;
        }

        // Build the result string from the stack.
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}