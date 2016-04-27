public class Solution {
    Set<String> res = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {

        
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(board, visited,"", i, j , trie);
            }
        }
        
        return new ArrayList<String>(res);
    }
    
    private void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return;
            
        if(visited[x][y] == true)
            return;
        
        str += board[x][y];
        if(!trie.startsWith(str))
            return;
        
        if(trie.search(str) == true)
            res.add(str);
        
        visited[x][y] = true;
        dfs(board, visited,str, x-1, y , trie);
        dfs(board, visited,str, x+1, y , trie);
        dfs(board, visited,str, x, y-1 , trie);
        dfs(board, visited,str, x, y+1 , trie);
        visited[x][y] = false;
    }
    
    class TrieNode {
        TrieNode[] branch;
        boolean isWord;
        // Initialize your data structure here.
        public TrieNode() {
             branch = new TrieNode[26];
        }
    }
    
    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(cur.branch[c-'a'] == null) cur.branch[c-'a'] = new TrieNode();
                cur = cur.branch[c-'a'];
            }
            cur.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(cur.branch[c-'a'] == null) return false;
                cur = cur.branch[c-'a'];
            }
            return cur.isWord == true;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for(int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if(cur.branch[c-'a'] == null) return false;
                cur = cur.branch[c-'a'];
            }
            return true;
        }
    }
}
