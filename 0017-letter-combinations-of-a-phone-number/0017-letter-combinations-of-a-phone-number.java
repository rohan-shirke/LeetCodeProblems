class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits.isEmpty()){
            return combinations;
        }
        backTrack(digits, 0, new StringBuilder(), combinations);
        return combinations;
    }

    public static final String[] phoneMapping = {
        "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };


    public void backTrack(String A, int index, StringBuilder current,List<String> combinations){
        if(index == A.length()){
            combinations.add(current.toString());
            return;
        }

        int digit = A.charAt(index)-'0';
        String letters = phoneMapping[digit];

        for(char letter : letters.toCharArray()){
            current.append(letter);
            backTrack(A, index+1, current, combinations);
            current.deleteCharAt(current.length()-1);
        }
    }
}