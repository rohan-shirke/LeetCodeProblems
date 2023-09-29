class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        backtrack(result, currentPartition, s, 0);
        return result;
    }
     private void backtrack(List<List<String>> result, List<String> currentPartition, String s, int startIndex) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
            if (isPalindrome(s, startIndex, endIndex)) {
                String palindromeSubstring = s.substring(startIndex, endIndex + 1);
                currentPartition.add(palindromeSubstring);
                backtrack(result, currentPartition, s, endIndex + 1);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}