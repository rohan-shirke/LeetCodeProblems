class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWordEnd;

    public TrieNode(){
        children = new HashMap<>();
        isWordEnd = false;
    }
}

class Trie {
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isWordEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.children.containsKey(ch)){
                return false;
            }
            node = node.children.get(ch);
        }
        return node.isWordEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            if(!node.children.containsKey(ch)){
                return false;
            }
            node = node.children.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */