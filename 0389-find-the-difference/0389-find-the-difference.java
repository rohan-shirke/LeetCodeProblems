class Solution {
    public char findTheDifference(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[] count = new int[26];
        // Count the occurrences of characters in string s
        for(char c : sArray){
           count[c-'a']++; 
        }
        // Decrease the count for each character in string t
        // If a character count becomes negative, it means it's the extra character
        for(char c : tArray){
            count[c-'a']--;
            if(count[c-'a']<0){
                return c;
            }
        }
        return ' ';// If no extra character is found
    }
}