class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;// Stores the size of the decoded string
        int n = s.length();

        // Calculate the size of the decoded string without actually decoding it
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int digit = c - '0';
                size *= digit;
            }else{
                size++;
            }
        }

        // Start from the end of the string and work backward
        for(int i=n-1; i>=0; i--){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int digit = c - '0';
                size /= digit; // Reduce the size by the digit factor
                k %= size; // Adjust k to be within the current size
            }else{
                if(k == 0 || k == size){
                    return String.valueOf(c); // Found the character at position k
                }
                size--; // Decrement size for a single character
            }
        }

        return null; // This line should never be reached
    }
}