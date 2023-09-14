class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return searchWord(root, word, 0);
    }

    private boolean searchWord(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (child != null && searchWord(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            return searchWord(node.children[ch - 'a'], word, index + 1);
        }
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */