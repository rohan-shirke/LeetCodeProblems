class Solution {
    public String removeDuplicateLetters(String s) {
         // Initialize an array to store the last occurrence index of each character in the string.
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        // Initialize a stack to build the result string.
        Stack<Character> stack = new Stack<>();
        // Initialize a boolean array to keep track of whether a character is already in the stack.
        boolean[] inStack = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the current character is not in the stack, we can consider adding it.
            if (!inStack[currentChar - 'a']) {
                // Check if the current character is smaller than the top character in the stack
                // and if there are more occurrences of the top character later in the string.
                while (!stack.isEmpty() && currentChar < stack.peek() && i < lastOccurrence[stack.peek() - 'a']) {
                    char removedChar = stack.pop();
                    inStack[removedChar - 'a'] = false;
                }
                // Add the current character to the stack and mark it as in the stack.
                stack.push(currentChar);
                inStack[currentChar - 'a'] = true;
            }
        }

        // Build the result string from the stack.
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}