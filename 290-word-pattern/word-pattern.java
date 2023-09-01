class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(pattern.length() != words.length){
            return false; // If the lengths of pattern and words don't match, return false
        }

        Map<Character, String> charToWordMap = new HashMap<>();

        for(int i = 0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            String word = words[i];

            // Check if the character is already mapped to a word
            if(charToWordMap.containsKey(ch)){
                // If it's mapped to a different word, return false
                if(!charToWordMap.get(ch).equals(word)){
                    return false;
                }
            }else{
                // Check if the word is already mapped to any character
                if(charToWordMap.containsValue(word)){
                    return false;
                }
                // Create new mappings
                charToWordMap.put(ch, word);
            }

        }

        return true;// If all characters and words match, return true
    }
}