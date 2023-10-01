class Solution {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int start = 0;

        for(int end = 0; end < ch.length; end++){
            // When a space is encountered or it's the last character
            if(ch[end] == ' '){
                reverseWord(ch, start, end-1);
                // Move the start pointer to the beginning of the next word
                start = end + 1;
            }
        }
        reverseWord(ch, start, ch.length - 1);
        return new String(ch);
    }
    // Helper function to reverse characters within a word
    public void reverseWord(char[] ch, int s, int e){
        while(s<e){
            char temp = ch[s];
            ch[s] = ch[e];
            ch[e] = temp;
            s++;
            e--;
        }
    }

}